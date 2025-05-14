package com.dobler.data

import com.dobler.data.converter.PopularMoviesConverter
import com.dobler.data.db.MovieDao
import com.dobler.data.model.MovieEntity
import com.dobler.data.repository.MyListRepositoryImplementation
import com.dobler.data.repository.SearchRepositoryImplementation
import com.dobler.domain.vo.MovieVO
import io.mockk.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import com.dobler.network.TmdbService
import com.dobler.network.model.PopularMoviesResponse
import io.mockk.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain

@OptIn(ExperimentalCoroutinesApi::class)
class SearchRepositoryImplementationTest {

    private lateinit var tmdbService: TmdbService
    private lateinit var repository: SearchRepositoryImplementation

    private val testDispatcher = TestCoroutineDispatcher()

    @Before
    fun setUp() {
        tmdbService = mockk()
        repository = SearchRepositoryImplementation(tmdbService)

        Dispatchers.setMain(testDispatcher)

        mockkObject(PopularMoviesConverter) // Mocka o objeto de conversão
    }

    @After
    fun tearDown() {
        unmockkAll()
        Dispatchers.resetMain()
    }

    @Test
    fun `search should handle empty result`() = runTest {
        // Simula o retorno de uma lista vazia de filmes
        val emptyApiResponse = emptyList<MovieVO>()

        coEvery { tmdbService.getPopularMovies(any()) } returns mockk<PopularMoviesResponse>(relaxed = true)

        every { PopularMoviesConverter.convertApi(any()) } returns emptyApiResponse

        val query = "non-existent query"
        val currentPage = 1
        val movies = repository.search(query, currentPage).toList()

        Assert.assertEquals(0, movies.size) // Espera lista vazia

        coVerify { tmdbService.getPopularMovies(query) }
    }
}
