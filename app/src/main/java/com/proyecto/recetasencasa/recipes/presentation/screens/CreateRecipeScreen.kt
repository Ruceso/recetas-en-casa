package com.proyecto.recetasencasa.recipes.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.proyecto.recetasencasa.recipes.presentation.components.BackHeader

@Composable
fun CreateRecipeScreen(
    name: String,
    description: String,
    time: String,
    onNameChange: (String) -> Unit,
    onDescriptionChange: (String) -> Unit,
    onTimeChange: (String) -> Unit,
    onSaveClick: () -> Unit
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ){
        BackHeader(
            title = "Nueva receta",
            onBackClick = {},
            modifier = Modifier.padding(bottom = 24.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = name,
            onValueChange = onNameChange,
            label = { Text("Nombre")},
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = description,
            onValueChange = onDescriptionChange,
            label = { Text("Descripción")},
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = time,
            onValueChange = onTimeChange,
            label = { Text("Tiempo (min)")},
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = onSaveClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Guardar receta")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CreateRecipeScreenPreview(){
    Surface{
        CreateRecipeScreen(
            name = "Pasta carbonara",
            description = "Receta italiana clásica con huevo y queso",
            time = "20",
            onNameChange = {},
            onDescriptionChange = {},
            onTimeChange = {},
            onSaveClick = {}
        )
    }
}