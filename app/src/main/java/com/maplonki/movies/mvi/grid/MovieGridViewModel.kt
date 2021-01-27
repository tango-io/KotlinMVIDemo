package com.maplonki.movies.mvi.grid

import android.widget.GridView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.maplonki.movies.mvi.grid.state.GridStateEvent
import com.maplonki.movies.mvi.grid.state.GridViewState
import com.maplonki.movies.mvi.model.MovieModel
import com.maplonki.movies.mvi.repository.MainRepository
import com.maplonki.movies.mvi.util.DataState

class MovieGridViewModel : ViewModel() {
    private val _stateEvent: MutableLiveData<GridStateEvent> = MutableLiveData()

    private val _viewState: MutableLiveData<GridViewState> = MutableLiveData()
    val viewState: LiveData<GridViewState>
        get() = _viewState

    val dataState: LiveData<DataState<GridViewState>> =
        Transformations.switchMap(_stateEvent) { stateEvent ->
            return@switchMap when (stateEvent) {
                is GridStateEvent.GetMovies -> {
                    MainRepository.getMovies()
                }
            }
        }

    fun setMovieList(movies: List<MovieModel>) {
        val update = getCurrentViewStateOrNew()
        update.movieList = movies;
        _viewState.value = update
    }

    fun getCurrentViewStateOrNew(): GridViewState {
        return viewState.value?.let {
            it
        } ?: GridViewState()
    }

    fun setViewState(viewState: GridStateEvent) {
        _stateEvent.value = viewState
    }

}