package com.dobler.data

import com.dobler.data.converter.PopularMoviesConverter
import com.dobler.data.db.MovieDao
import com.dobler.data.model.MovieEntity
import com.dobler.data.repository.MyListRepositoryImplementation
import com.dobler.domain.vo.MovieVO
import io.mockk.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class MyListRepositoryImplementationTest {

    private lateinit var movieDao: MovieDao
    private lateinit var repository: MyListRepositoryImplementation

    @Before
    fun setUp() {
        movieDao = mockk(relaxed = true) // Mocka o DAO
        repository = MyListRepositoryImplementation(movieDao)
        mockkObject(PopularMoviesConverter) // Mocka o objeto de conversão
    }

    @After
    fun tearDown() {
        unmockkAll() // Remove todos os mocks
    }

    @Test
    fun `get allMovies should return list of movies`() = runTest {
        val movieEntities = listOf(
            MovieEntity(1, "Movie 1", "Overview 1", "Path 1"),
            MovieEntity(2, "Movie 2", "Overview 2", "Path 2")
        )
        val expectedMovies = listOf(
            MovieVO(1, "Movie 1", "Overview 1", "Path 1"),
            MovieVO(2, "Movie 2", "Overview 2", "Path 2")
        )

        every { movieDao.getAllMovies() } returns movieEntities
        every { PopularMoviesConverter.convertDatabase(movieEntities) } returns expectedMovies

        val movies = repository.allMovies.first()

        Assert.assertEquals(expectedMovies, movies)
        verify { movieDao.getAllMovies() }
        verify { PopularMoviesConverter.convertDatabase(movieEntities) }
    }


}
