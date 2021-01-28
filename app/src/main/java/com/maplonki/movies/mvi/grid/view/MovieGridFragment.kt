package com.maplonki.movies.mvi.grid.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.maplonki.movies.mvi.R
import com.maplonki.movies.mvi.detail.view.MovieDetailFragment
import com.maplonki.movies.mvi.grid.MovieGridViewModel
import com.maplonki.movies.mvi.grid.state.GridStateEvent

class MovieGridFragment : Fragment(R.layout.fragment_movie_grid) {

    private lateinit var viewModel: MovieGridViewModel

    val gridAdapter: MovieGridAdapter by lazy {
        MovieGridAdapter { selectedMovie ->

            requireActivity()
                .supportFragmentManager
                .beginTransaction()
                .add(
                    R.id.activity_container,
                    MovieDetailFragment.newInstance(selectedMovie.id ?: 0L)
                )
                .addToBackStack(null)
                .commit()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = activity?.run {
            ViewModelProvider(
                this,
                ViewModelProvider.AndroidViewModelFactory.getInstance(application)
            ).get(MovieGridViewModel::class.java)
        } ?: throw Exception("Invalid activity")

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<RecyclerView>(R.id.movie_grid_recyclerView).apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(activity, 3)
            adapter = gridAdapter
        }

        subscribeObservers()
        viewModel.setViewState(GridStateEvent.GetMovies)

    }

    private fun subscribeObservers() {
        viewModel.dataState.observe(viewLifecycleOwner, Observer { dataState ->

            dataState.data?.let { gridViewState ->
                gridViewState?.movieList?.let { movies ->
                    viewModel.setMovieList(movies)
                }
            }
        })

        viewModel.viewState.observe(viewLifecycleOwner, { viewState ->
            viewState.movieList?.let {
                gridAdapter.movieList = it
            }
        })
    }

}