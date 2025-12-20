package com.proyecto.recetasencasa.dashboard.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.MenuBook
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.proyecto.recetasencasa.core.presentation.components.BottomNavigationBar
import androidx.compose.material.icons.filled.Restaurant
import androidx.compose.material.icons.filled.ShoppingCart
import com.proyecto.recetasencasa.core.presentation.components.Header
import com.proyecto.recetasencasa.dashboard.presentation.components.DashboardStatItem


@Composable
fun DashboardScreen(
    userName: String,
    totalRecipes: Int,
    plannedMeals: Int,
    ingredients: Int,
    recipesFav: Int,
    onViewRecipesClick: () -> Unit
) {
    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                onHomeClick = {},
                onRecipesClick = {},
                onCreateClick = {},
                onPlannerClick = {},
                onShoppingClick = {}
            )
        }
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            Header(
                icon = Icons.Default.Restaurant,
                title = "Las recetas de $userName",
                modifier = Modifier.padding(bottom = 24.dp)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                DashboardStatItem(
                    icon = Icons.AutoMirrored.Outlined.MenuBook,
                    label = "Recetas",
                    value = totalRecipes,
                    modifier = Modifier.weight(1f)
                )

                DashboardStatItem(
                    icon = Icons.Default.DateRange,
                    label = "Planificar",
                    value = plannedMeals,
                    modifier = Modifier.weight(1f)
                )

            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                DashboardStatItem(
                    icon = Icons.Default.ShoppingCart,
                    label = "Compra",
                    value = ingredients,
                    modifier = Modifier.weight(1f)
                )

                DashboardStatItem(
                    icon = Icons.Default.Favorite,
                    label = "Favoritas",
                    value = recipesFav,
                    modifier = Modifier.weight(1f)
                )

            }

                Spacer(modifier = Modifier.height(24.dp))

                Button(onClick = onViewRecipesClick) {
                    Text(text = "Ver recetas")
                }
        }
        }
    }

@Preview(showBackground = true)
@Composable
fun DashboardScreenPreview() {
    Surface{
        DashboardScreen(
            userName = "Rubén",
            totalRecipes = 12,
            plannedMeals = 8,
            ingredients = 18,
            recipesFav = 12,
            onViewRecipesClick = {}
        )
    }
}