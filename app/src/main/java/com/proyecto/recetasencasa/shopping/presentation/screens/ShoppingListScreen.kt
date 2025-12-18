package com.proyecto.recetasencasa.shopping.presentation.screens

import android.R
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ShoppingListScreen(
    items: List<String>,
    onItemClick: (String) -> Unit
){
    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(items) { item ->
            Text(
                text = item,
                modifier = Modifier
                    .padding(8.dp)
                    .clickable{ onItemClick(item)},
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShoppingListScreenPreview(){
    Surface {
        ShoppingListScreen(
            items = listOf(
                "Tomates - 2 kg",
                "Queso - 1 paquete",
                "Huevos - 12 unidades",
                "Leche - 2 litros"
            ),
            onItemClick = {}
        )
    }
}