package com.dobler.search

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dobler.domain.repository.MyListRepository
import com.dobler.domain.repository.SearchRepository
import com.dobler.domain.vo.MovieVO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SearchViewModel(private val searchRepository: SearchRepository, private val myListRepository: MyListRepository) : ViewModel() {

    private val _uiState: MutableStateFlow<SearchUiState> = MutableStateFlow(SearchUiState.Default)
    val uiState: StateFlow<SearchUiState> = _uiState.asStateFlow()

    private val _movies = MutableStateFlow<List<MovieVO>>(emptyList())
    val movies: StateFlow<List<MovieVO>> = _movies

    private var lastSearchedQuery = ""
    private var currentPage = 1

    private   fun loadNextPage() {
        viewModelScope.launch {
            searchRepository.search(lastSearchedQuery, currentPage).collect { newMovies ->
                _movies.emit(_movies.value + newMovies)
                _uiState.emit(SearchUiState.Success)
                currentPage++
            }
        }
    }

    fun search(query: String ) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                currentPage = 1
                lastSearchedQuery = query
                _uiState.emit(SearchUiState.Loading)
                searchRepository.search(query, currentPage).collect { newMovies ->
                    _movies.emit(_movies.value + newMovies)
                }

                _uiState.emit(SearchUiState.Success)
                loadNextPage()
            } catch (e: Exception) {
                Log.e("SearchViewModel", "Error searching movies", e.cause )
                viewModelScope.launch {
                    _uiState.emit(SearchUiState.Error(e))
                }
            }
        }
    }

    fun saveMovie(movieVo: MovieVO) {
        viewModelScope.launch {
            myListRepository.insertMovie(movieVo)
        }
    }


}

sealed class SearchUiState {
    object Loading : SearchUiState()
    object Default : SearchUiState()
    object Success : SearchUiState()
    data class Error(val exception: Throwable) : SearchUiState()
}

