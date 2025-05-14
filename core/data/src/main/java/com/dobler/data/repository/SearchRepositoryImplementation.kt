package com.dobler.data.repository

import com.dobler.data.converter.PopularMoviesConverter
import com.dobler.domain.repository.SearchRepository
import com.dobler.domain.vo.MovieVO
import com.dobler.network.TmdbService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class SearchRepositoryImplementation(private val tmdbService: TmdbService ) : SearchRepository {

    override fun search(query: String, currentPage: Int): Flow<List<MovieVO>> {
        return flow{
            val request = tmdbService.getPopularMovies(query)
                emit(PopularMoviesConverter.convertApi(request))
            }.flowOn(Dispatchers.IO)
        }

    }

