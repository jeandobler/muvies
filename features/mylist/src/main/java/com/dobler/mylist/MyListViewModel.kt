package com.dobler.mylist

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dobler.domain.repository.MyListRepository
import com.dobler.domain.vo.MovieVO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MyListViewModel(private val myListRepository: MyListRepository) : ViewModel() {

    private val _uiState: MutableStateFlow<MyListUiState> = MutableStateFlow(MyListUiState.Default)
    val uiState: StateFlow<MyListUiState> = _uiState.asStateFlow()

    private val _movies = MutableStateFlow<List<MovieVO>>(emptyList())
    val movies: StateFlow<List<MovieVO>> = _movies

    fun myList() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _uiState.emit(MyListUiState.Loading)
                myListRepository.allMovies.collect { newMovies ->
                    _movies.emit(newMovies)
                }

                _uiState.emit(MyListUiState.Success)

            } catch (e: Exception) {
                viewModelScope.launch {
                    _uiState.emit(MyListUiState.Error(e))
                }
            }
        }
    }

    fun deleteMovie(movieVo: MovieVO) {
        try {
            viewModelScope.launch(Dispatchers.IO) {
                myListRepository.deleteMovie(movieVo)
                delay(500)
                myList()
            }
        } catch (e: Exception) {
            Log.e("MyListViewModel", "Error deleting movie", e.cause )
        }
    }

}

sealed class MyListUiState {
    object Loading : MyListUiState()
    object Default : MyListUiState()
    object Success : MyListUiState()
    data class Error(val exception: Throwable) : MyListUiState()
}

