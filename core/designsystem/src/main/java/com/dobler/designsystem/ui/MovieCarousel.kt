package com.dobler.designsystem.ui


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dobler.domain.vo.MovieVO

@Composable
fun MovieCarousel(
    movies: List<MovieVO>,
    modifier: Modifier = Modifier,
    search: (MovieVO) -> Unit
) {
    Column(modifier = modifier.fillMaxWidth()) {

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(16.dp)
        ) {
            items(movies) { movie ->
                MovieCard(movie, Modifier.clickable { search(movie) })
            }
        }
    }
}
