package com.dobler.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.dobler.designsystem.R
import com.dobler.designsystem.ui.MovieCarousel
import com.dobler.designsystem.ui.RoundedSearchBar
import org.koin.androidx.compose.koinViewModel


@Composable
fun Search(
    name: String,
    modifier: Modifier = Modifier,
    viewModel: SearchViewModel = koinViewModel()
) {

    var searchedWord by remember { mutableStateOf("") }

    Column(
        modifier
            .fillMaxSize()
            .paint(
                painterResource(id = R.drawable.background),
                contentScale = ContentScale.FillHeight
            )
    ) {

        Text(
            text = "$name ",
            modifier = Modifier.padding(16.dp) // Não use o modifier do parâmetro aqui se não for necessário
        )


        RoundedSearchBar(modifier = Modifier.padding(8.dp)) { s ->
            searchedWord = s
        }

        Button(onClick = { viewModel.search(searchedWord) }, modifier = Modifier.padding(8.dp).fillMaxWidth()) {
            Text(text = "Search")
        }

        Text(
            text = "Buscado por:$searchedWord",
            modifier = Modifier.padding(8.dp) // Não use o modifier do parâmetro aqui se não for necessário
        )


        val movieList by viewModel.movies.collectAsState()
        val searchState by viewModel.uiState.collectAsState()

        when (searchState) {
            SearchUiState.Success -> {
                MovieCarousel(movieList) { viewModel.saveMovie(it) }
            }
            SearchUiState.Loading -> {
                CircularProgressIndicator()
            }


            else -> {
//                CircularProgressIndicator()
            }
        }

    }
}
