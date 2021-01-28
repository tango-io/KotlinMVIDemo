package com.maplonki.movies.mvi.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.maplonki.movies.mvi.detail.state.DetailStateEvent
import com.maplonki.movies.mvi.detail.state.DetailViewState
import com.maplonki.movies.mvi.model.MovieModel
import com.maplonki.movies.mvi.util.DataState

class MovieDetailViewModel : ViewModel() {

    private val _stateEvent: MutableLiveData<DetailStateEvent> = MutableLiveData()

    private val _viewState: MutableLiveData<DetailViewState> = MutableLiveData()
    val viewState: LiveData<DetailViewState>
        get() = _viewState

    val dataState: LiveData<DataState<DetailViewState>> =
        Transformations.switchMap(_stateEvent) { stateEvent ->
            return@switchMap when (stateEvent) {
                is DetailStateEvent.GetMovieDetail -> {
                    DetailRepository.getMovieDetail(stateEvent.movieid)
                }
            }
        }

    fun setMovieDetail(movie: MovieModel) {
        val update = getCurrentViewStateOrNew()
        update.movie = movie;
        _viewState.value = update
    }

    fun getCurrentViewStateOrNew(): DetailViewState {
        return viewState.value?.let {
            it
        } ?: DetailViewState()
    }

    fun setViewState(viewState: DetailStateEvent) {
        _stateEvent.value = viewState
    }

}