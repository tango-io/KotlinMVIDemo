package com.maplonki.movies.mvi.detail.view

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.maplonki.movies.mvi.R
import com.maplonki.movies.mvi.detail.MovieDetailViewModel
import com.maplonki.movies.mvi.detail.state.DetailStateEvent
import com.maplonki.movies.mvi.extensions.*
import com.maplonki.movies.mvi.model.MovieModel


class MovieDetailFragment : Fragment(R.layout.fragment_movie_detail) {

    companion object {
        fun newInstance(movieId: Long): MovieDetailFragment {
            return MovieDetailFragment().apply {
                arguments = bundleOf("movie_id" to movieId.toString())
            }
        }
    }

    private lateinit var detailViewModel: MovieDetailViewModel

    private var movieId: String? = null


    lateinit var toolbar: CollapsingToolbarLayout
    lateinit var movieDate: TextView
    lateinit var movieRating: TextView
    lateinit var movieCover: ImageView
    lateinit var moviePoster: ImageView
    lateinit var movieOverview: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        detailViewModel = activity?.run {
            ViewModelProvider(
                this,
                ViewModelProvider.AndroidViewModelFactory.getInstance(application)
            ).get(MovieDetailViewModel::class.java)
        } ?: throw Exception("Invalid activity")

        movieId = arguments?.getString("movie_id")

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        toolbar = view.findViewById(R.id.detail_collapsing_toolbar)
        movieDate = view.findViewById(R.id.detail_tv_release_date)
        movieRating = view.findViewById(R.id.detail_tv_rating)
        movieCover = view.findViewById(R.id.detail_iv_backdrop)
        moviePoster = view.findViewById(R.id.detail_iv_poster)
        movieOverview = view.findViewById(R.id.detail_tv_overview)

        subscribeToObservers()
        movieId?.let {
            detailViewModel.setViewState(DetailStateEvent.GetMovieDetail(it))
        }
    }

    private fun subscribeToObservers() {
        detailViewModel.dataState.observe(viewLifecycleOwner, { dataState ->
            dataState?.data?.let { state ->
                state.movie?.let {
                    detailViewModel.setMovieDetail(it)
                }
            }
        })

        detailViewModel.viewState.observe(viewLifecycleOwner, { viewState ->
            viewState.movie?.let {
                initDetailView(it)
            }
        })
    }

    private fun initDetailView(movie: MovieModel) {

        toolbar.title = movie.title
        movieDate.text = movie.releaseDateFormatted(requireContext())
        movieRating.text = movie.ratingFormatted(requireContext())
        movieOverview.text = movie.overview

        moviePoster.loadImage(movie.fullPoster())
        movieCover.loadImage(movie.fullCover())
    }

}