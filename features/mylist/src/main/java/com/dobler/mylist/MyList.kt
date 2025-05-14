package com.dobler.mylist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.dobler.designsystem.R
import com.dobler.designsystem.ui.MovieCarousel
import com.dobler.designsystem.ui.RoundedSearchBar
import org.koin.androidx.compose.koinViewModel


@Composable
fun MyList(name: String, modifier: Modifier = Modifier, viewModel: MyListViewModel = koinViewModel()) {

    LaunchedEffect(Unit) { // Restart the effect when the pulse rate changes
        viewModel.myList()
    }

    Column(
        modifier
            .fillMaxSize()
            .paint(
                painterResource(id = R.drawable.background),
                contentScale = ContentScale.FillHeight
            )
    ) {

        Text(
            text = " $name ",
            modifier = Modifier
        )

        val movieList by viewModel.movies.collectAsState()
        val searchState by viewModel.uiState.collectAsState()

        when (searchState) {
            MyListUiState.Success -> {
                MovieCarousel(movieList) { viewModel.deleteMovie(it) }
            }

            else -> {
                CircularProgressIndicator()
            }
        }
    }
}
