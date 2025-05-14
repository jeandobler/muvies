package com.dobler.designsystem.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dobler.domain.Navigation

@Composable
fun MyBottomBarWithTwoItems(param: (Navigation) -> Unit) = BottomAppBar {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceAround // Distribui os itens uniformemente
    ) {
        IconButton(onClick = {
            param(Navigation.SEARCH)
        }) {
            Icon(
                imageVector = Icons.Filled.Search, // Ícone de lupa para Busca
                contentDescription = "Buscar"
            )
        }
        IconButton(onClick = { param(Navigation.MYLIST) }) {
            Icon(
                imageVector = Icons.Filled.Favorite, // Ícone de estrela (ou outro de sua preferência) para Minha Lista
                contentDescription = "Minha Lista"
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun PreviewMyBottomBarWithTwoItems() {
    MyBottomBarWithTwoItems {    }
}