package com.proyecto.recetasencasa.planner.presentation.screens


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Icon
import androidx.compose.ui.Alignment

@Composable
fun WeekPlannerScreen(
    day: String,
    meals: Map<String, String?>,
    dayStart: Int,
    dayEnd: Int,
    monthStart: String,
    monthEnd: String,
    onDayClick: (String) -> Unit,   // No se usa de momento, falta añadir una barra para seleccionar el dia
    onMealClick: (String) -> Unit
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
            Row(
                modifier = Modifier
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBackIosNew,
                    contentDescription = "Semana anterior",
                    modifier = Modifier
                        .weight(1f)
                        .clickable{}
                )

                Column(
                    modifier = Modifier.weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        text = "Semana del",
                        style = MaterialTheme.typography.bodySmall

                    )
                    Text(
                        text = "$dayStart $monthStart - $dayEnd $monthEnd",
                        style = MaterialTheme.typography.bodySmall
                    )
                }

                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
                    contentDescription = "Semana siguiente",
                    modifier = Modifier
                        .weight(1f)
                        .clickable{}
                )

            }

            Text(
                text = day,
                style = MaterialTheme.typography.titleMedium
            )

            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(8.dp)
            ) {

                items (meals.entries.toList()) { entry ->
                    val moment = entry.key
                    val recipe = entry.value

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp)
                            .clickable { onMealClick(moment) },
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = moment,
                            style = MaterialTheme.typography.bodyLarge
                        )

                        Text(
                            text = recipe ?: "Sin asignar",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
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
            day = "Lunes",
            meals = mapOf(
                "Desayuno" to "Tostadas",
                "Almuerzo" to "Plátano",
                "Comida" to "Pasta",
                "Merienda" to null,
                "Cena" to "Ensalada"
            ),
            dayStart = 28,
            dayEnd = 3,
            monthStart = "Oct",
            monthEnd = "Nov",
            onDayClick = {},
            onMealClick = {}
        )
    }
}