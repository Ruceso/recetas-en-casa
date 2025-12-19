package com.proyecto.recetasencasa.core.presentation.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.MenuBook
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun BottomNavigationBar(
    onHomeClick: () -> Unit,
    onRecipesClick: () -> Unit,
    onCreateClick: () -> Unit,
    onPlannerClick: () -> Unit,
    onShoppingClick: () -> Unit
){
    NavigationBar {
        NavigationBarItem(
            selected = false,
            onClick = onHomeClick,
            icon = {
                Icon(Icons.Default.Home, contentDescription = "Inicio")
            }
        )
        NavigationBarItem(
            false,
            onClick = onRecipesClick,
            icon = {
                Icon(
                    imageVector = Icons.AutoMirrored.Outlined.MenuBook,
                    contentDescription = "Recetas"
                )
            }
        )

        NavigationBarItem(
            selected = false,
            onClick = onCreateClick,
            icon = {
                Icon(Icons.Default.Add, contentDescription = "Crear receta")
            }
        )

        NavigationBarItem(
            selected = false,
            onClick = onPlannerClick,
            icon = {
                Icon(Icons.Default.DateRange, contentDescription = "Planificar")
            }
        )

        NavigationBarItem(
            selected = false,
            onClick = onShoppingClick,
            icon = {
                Icon(Icons.Default.ShoppingCart, contentDescription = "Compras")
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BottomNavigationBarPreview(){
    Surface {
        BottomNavigationBar(
            {},
            onRecipesClick = {},
            onCreateClick = {},
            onPlannerClick = {},
            onShoppingClick = {}
        )
    }
}