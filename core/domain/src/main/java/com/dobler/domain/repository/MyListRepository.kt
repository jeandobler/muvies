package com.dobler.domain.repository

import com.dobler.domain.vo.MovieVO
import kotlinx.coroutines.flow.Flow

interface MyListRepository {
    val allMovies: Flow<List<MovieVO>>
    suspend fun insertMovie(movie: MovieVO)
    suspend fun deleteMovie(movie: MovieVO)
}

