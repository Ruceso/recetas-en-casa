package com.proyecto.recetasencasa.dashboard.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DashboardScreen(
    userName: String,
    totalRecipes: Int,
    plannedMeals: Int,
    onViewRecipesClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ){
        Text(
            text = "Hola, $userName",
            style = MaterialTheme.typography.headlineMedium
        )

        Text(text = "Recetas: $totalRecipes")
        Text(text = "Planificadas: $plannedMeals")

        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = onViewRecipesClick){
            Text(text = "Ver recetas")
        }
    }
}