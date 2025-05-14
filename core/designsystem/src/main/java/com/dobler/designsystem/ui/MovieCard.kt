package com.dobler.designsystem.ui


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dobler.domain.vo.MovieVO

@Composable
fun MovieCard(
    movie: MovieVO,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.padding(bottom = 4.dp), // Pequeno padding na parte inferior
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column {
            NetworkImage(imageUrl = movie.posterPath)

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp)
            ) {
                Text(
                    text = movie.title,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

            }
        }
    }
}
