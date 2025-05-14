package com.dobler.data.converter

import com.dobler.data.model.MovieEntity
import com.dobler.domain.vo.MovieVO
import com.dobler.network.model.PopularMoviesResponse

class PopularMoviesConverter {

    companion object {
        fun convertApi(response: PopularMoviesResponse): List<MovieVO> {
            val movies = mutableListOf<MovieVO>()

            for (movie in response.results) {
                val movieVO = MovieVO(
                    title = movie.title,
                    overview = movie.overview,
                    posterPath = movie.posterPath,
                    id = movie.id
                )
                movies.add(movieVO)
            }

            return movies
        }

        fun convertDatabase(response: List<MovieEntity>): List<MovieVO> {
            val movies = mutableListOf<MovieVO>()

            for (movie in response) {
                val movieVO = MovieVO(
                    title = movie.title,
                    overview = movie.overview,
                    posterPath = movie.posterPath,
                    id = movie.id
                )
                movies.add(movieVO)
            }

            return movies
        }


        fun convertMoviesEntity(response: MovieVO): MovieEntity = MovieEntity(
            title = response.title,
            overview = response.overview,
            posterPath = response.posterPath,
            id = response.id
        )

    }
}