package com.proyecto.recetasencasa.recipes.presentation.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun RecipeListScreen(
    recipes: List<String>,
    onRecipeClick: (String) -> Unit
){
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(recipes) { recipe ->
            Text(
                text = recipe,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .clickable{onRecipeClick(recipe)}
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RecipeListScreenPreview(){
    Surface{
        RecipeListScreen(
            recipes = listOf(
                "Pasta carbonara",
                "Ensalada César",
                "Pizza margarita",
                "Tortilla de patatas"
            ),
            onRecipeClick = {}
        )
    }
}