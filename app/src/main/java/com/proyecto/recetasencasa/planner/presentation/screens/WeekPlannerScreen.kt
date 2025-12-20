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
    meals: List<String>,
    dayStart: Int,
    dayEnd: Int,
    monthStart: String,
    monthEnd: String,
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
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(8.dp)
            ) {
                items (meals) { meal ->
                    Text(
                        text = meal,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp)
                            .clickable { onDayClick(meal) },
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
            day = "Lunes",
            meals = listOf(
                "Desayuno",
                "Almuerzo",
                "Comida",
                "Merienda",
                "Cena"
            ),
            dayStart = 28,
            dayEnd = 3,
            monthStart = "Oct",
            monthEnd = "Nov",
            onDayClick = {}
        )
    }
}