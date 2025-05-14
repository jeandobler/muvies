package com.dobler.designsystem

import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import com.dobler.designsystem.ui.MovieCard
import com.dobler.designsystem.ui.MovieCarousel
import com.dobler.designsystem.ui.MyBottomBarWithTwoItems
import com.dobler.designsystem.ui.RoundedSearchBar
import com.dobler.domain.Navigation
import com.dobler.domain.vo.MovieVO
import org.junit.Rule
import org.junit.Test
import org.robolectric.annotation.Config

@Config(sdk = [30])
class MovieCardTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testMovieCardDisplaysCorrectData() {
        val movie = MovieVO(
            id = 1,
            title = "Test Movie",
            overview = "A great movie to test",
            posterPath = "test_path.jpg"
        )

        composeTestRule.setContent {
            MovieCard(movie = movie)
        }

        // Testa se o título do filme está sendo exibido corretamente
        composeTestRule.onNodeWithText("Test Movie").assertExists()

        // Testa se o overview não está sendo exibido, conforme esperado
        composeTestRule.onNodeWithText("A great movie to test").assertDoesNotExist()
    }

    @Test
    fun testMovieCarouselDisplaysMovies() {
        val testMovies = listOf(
            MovieVO(1, "Movie 1", "Overview 1", "path1.jpg"),
            MovieVO(2, "Movie 2", "Overview 2", "path2.jpg")
        )

        var clickedMovie: MovieVO? = null

        composeTestRule.setContent {
            MovieCarousel(
                movies = testMovies,
                search = { clickedMovie = it }
            )
        }

        testMovies.forEach { movie ->
            composeTestRule.onNodeWithText(movie.title).assertExists()
        }

        composeTestRule.onNodeWithText("Movie 1").performClick()

        assert(clickedMovie == testMovies[0])
    }

    @Test
    fun testRoundedSearchBarInput() {
        var searchText = ""

        composeTestRule.setContent {
            RoundedSearchBar(
                modifier = Modifier.testTag("SearchBar"),
                onSearch = { searchText = it }
            )
        }

        val inputText = "Hello"
        composeTestRule.onNodeWithTag("SearchBar").performTextInput(inputText)

        assert(searchText == inputText)
    }

    @Test
    fun testMyBottomBarClicks() {
        var navigation: Navigation? = null

        composeTestRule.setContent {
            MyBottomBarWithTwoItems { nav ->
                navigation = nav
            }
        }

        composeTestRule.onNodeWithContentDescription("Buscar").performClick()
        assert(navigation == Navigation.SEARCH)

        composeTestRule.onNodeWithContentDescription("Minha Lista").performClick()
        assert(navigation == Navigation.MYLIST)
    }
}

