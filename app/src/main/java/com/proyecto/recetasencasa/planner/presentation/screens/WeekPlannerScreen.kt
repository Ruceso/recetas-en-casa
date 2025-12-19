package com.proyecto.recetasencasa.planner.presentation.screens


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.proyecto.recetasencasa.core.presentation.components.BottomNavigationBar
import com.proyecto.recetasencasa.core.presentation.components.Header
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange

@Composable
fun WeekPlannerScreen(
    plan: Map<String, String>,
    onDayClick: (String) -> Unit
){
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
                icon = Icons.Default.DateRange,
                title = "Recetas de la semana"
            )
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize(),
                contentPadding = PaddingValues(16.dp)
            ) {
                items(plan.entries.toList()) { (day, recipe) ->
                    Text(
                        text = "$day - $recipe",
                        modifier = Modifier
                            .padding(8.dp)
                            .clickable { onDayClick(day) },
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun WeekPlannerScreenPreview(){
    Surface{
        WeekPlannerScreen(
            plan = mapOf(
                "Lunes" to "Pasta",
                "Martes" to "Ensalada",                "Miercoles" to "Pizza",
                "Jueves" to "Tortilla",
                "Viernes" to "Hamburguesa"
            ),
            onDayClick = {}
        )
    }
}