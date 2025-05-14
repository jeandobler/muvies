package com.dobler.data.repository

import com.dobler.data.converter.PopularMoviesConverter
import com.dobler.data.db.MovieDao
import com.dobler.data.model.MovieEntity
import com.dobler.domain.repository.MyListRepository
import com.dobler.domain.vo.MovieVO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class MyListRepositoryImplementation(private val movieDao: MovieDao) : MyListRepository {

    override val allMovies: Flow<List<MovieVO>> = flow {
        emit( PopularMoviesConverter.convertDatabase(movieDao.getAllMovies()))
    }

    override suspend fun insertMovie(movie: MovieVO) {
        movieDao.insertMovie( PopularMoviesConverter.convertMoviesEntity(movie))
    }

    override suspend fun deleteMovie(movie: MovieVO) {
        movieDao.deleteMovie(movie.id)
    }
}
