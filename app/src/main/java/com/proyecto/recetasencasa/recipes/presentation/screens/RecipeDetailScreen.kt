package com.proyecto.recetasencasa.recipes.presentation.screens

import android.R
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun RecipeDetailScreen(
    name: String,
    time: Int,
    difficulty: String,
    description: String,
    ingredients: List<String>
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ){
        Text(
            text = name,
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(text = "Tiempo: $time min")
        Text(text = "Dificultad: $difficulty")

        Spacer(modifier = Modifier.height(24.dp))

        Text(text = "Descripción:\n $description")

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Ingredientes",
            style = MaterialTheme.typography.titleMedium
        )
        ingredients.forEach { ingredient ->
            Text(text = "- $ingredient")
        }
    }
}