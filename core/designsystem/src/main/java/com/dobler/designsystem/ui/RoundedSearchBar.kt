package com.dobler.designsystem.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun RoundedSearchBar(
    modifier: Modifier = Modifier,
    onSearch: (String) -> Unit
) {
    var text by remember { mutableStateOf("") }

     OutlinedTextField(
        value = text,
        onValueChange = {
            text = it
            onSearch(it)
        },
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        placeholder = { Text("Buscar...") },
        leadingIcon = {
             Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Ícone de busca"
            )
        },
        shape = RoundedCornerShape(8.dp), // Aplica cantos arredondados
        colors = OutlinedTextFieldDefaults.colors(
            // focusedBorderColor = MaterialTheme.colorScheme.primary,
            // unfocusedBorderColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f),
            // cursorColor = MaterialTheme.colorScheme.primary,
        ),
        singleLine = true // Garante que o texto fique em uma única linha
    )
}

@Preview(showBackground = true)
@Composable
fun RoundedSearchBarPreview() {
    RoundedSearchBar(onSearch = {   })
}