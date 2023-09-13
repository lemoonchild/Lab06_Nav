package com.example.lab06navigation.ui.detail.view

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.lab06navigation.ui.detail.viewmodel.ConcertDetailViewModel


@Composable
fun ConcertDetail(concertId: String) {

    val viewModel: ConcertDetailViewModel = viewModel()
    val concert = viewModel.getConcertById(concertId)

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
        ) {
            // Imagen en la parte superior
            if (concert != null) {
                Image(
                    painter = painterResource(id = concert.imageRes),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }

            // Círculo blanco detrás del ícono de flecha para regresar
            Box(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(16.dp)
                    .size(36.dp)
                    .background(Color.White, shape = CircleShape)  // Fondo circular de color blanco
            ) {
                // Botón de flecha para regresar
                IconButton(
                    onClick = {
                        Log.d("ConcertClick", "Regresa") //FUNCIONA MAMAHUEVO
                    }
                ) {
                    Icon(Icons.Filled.ArrowBack, contentDescription = "Back", tint = Color.Black)
                }
            }
        }
        // Cuadro que cubre la mitad inferior de la pantalla, aqui se encuentra la información de los conciertos
        Box(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
                .background(Color.White)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                // Parte superior del cuadro
                Column(
                    verticalArrangement = Arrangement.spacedBy(20.dp), // Espaciado vertical entre elementos
                    horizontalAlignment = Alignment.Start
                ) {
                    // Informacion del concierto
                    if (concert != null) {
                        Text(text = "Place: ${concert.location}", fontSize = 18.sp)
                    }
                    if (concert != null) {
                        Text(text = "Band: ${concert.name}", fontWeight = FontWeight.Bold, fontSize = 22.sp)
                    }
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.Start,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(imageVector = Icons.Default.CalendarToday, contentDescription = null) // icono de calendario
                            // Fecha del concierto al lado de icono
                            if (concert != null) {
                                Text(text = "Date: ${concert.date}", fontSize = 16.sp)
                            }
                        }
                        // Hora del concierto
                        if (concert != null) {
                            Text(text = "Hour: ${concert.time}", fontSize = 16.sp)
                        }
                    }
                    // Informacion extra sobre el concierto
                    Text(text = "About:", fontSize = 16.sp)
                    if (concert != null) {
                        Text(text = concert.description, fontSize = 16.sp)
                    }
                }

                // Parte inferior del cuadro
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    // Boton "Favorite"
                    Button(
                        onClick = { /* no hace nada */ },
                        colors = ButtonDefaults.buttonColors(Color(0xFFE5DDFB), contentColor = Color.Black)

                    ) {
                        Text(text = "Favorite")
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    // Boton "Buy"
                    Button(
                        onClick = { /* no hace nada */ },
                        colors = ButtonDefaults.buttonColors(Color(0xFFE5DDFB), contentColor = Color.Black)
                    ) {
                        Text(text = "Buy")
                    }
                }

            }
        }
    }
}
