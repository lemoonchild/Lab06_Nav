package com.example.lab06navigation.ui.concerts.view

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material3.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.lab06navigation.navegation.model.Screen
import com.example.lab06navigation.ui.concerts.viewmodel.Concert
import com.example.lab06navigation.ui.concerts.viewmodel.ConcertsViewModel.ConcertRepository


@Composable
fun DisplayConcerts(navController: NavController) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 1.dp),
            horizontalAlignment = Alignment.Start
        ) {
            // Encabezado de la aplicación
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFE5DDFB)) // Cambiar color de fondo del encabezado
            ) {
                Row(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "TodoEventos",
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            fontSize = 25.sp,
                            color = MaterialTheme.colorScheme.onSurface // color del texto
                        )
                    )
                    Icon(
                        imageVector = Icons.Default.MoreVert,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onSurface
                    )
                }

            }
            // Mostrar lista de conciertos guardados
            ConcertsList(navController)
        }
    }
}


// Composable para mostrar la lista de conciertos
@Composable
fun ConcertsList(navController: NavController) {

    val allConcerts = ConcertRepository.getAllSampleConcerts()

    LazyColumn(
        contentPadding = PaddingValues(16.dp)
    ) {
        // Seccion de todos los conciertos
        item {
            Text("All Concerts", fontSize = 20.sp)
            Spacer(modifier = Modifier.height(10.dp))
        }

        itemsIndexed(allConcerts.chunked(2)) { index, pair ->
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                pair.forEach { concert ->
                    Box(
                        Modifier.weight(1f)
                    ) {
                        ConcertCard(concert, navController) {
                            navController.navigate("detail/${concert.name}")
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(18.dp))
        }
    }
}


// Composable para mostrar un elemento de concierto
@Composable
fun ConcertCard(concert: Concert, navController: NavController, function: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(8.dp))
            .clickable {
                val route = "concert_detail/${concert.name}"
                Log.d("Navigation", "Navigating to: $route")
                navController.navigate(Screen.ConcertDetail.route + "/${concert.name}")}
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFFBDDE4)) // Cambio de color a las cards
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(1.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {
                Image(
                    painter = painterResource(id = concert.imageRes),
                    contentDescription = null,
                    modifier = Modifier
                        .height(150.dp)
                        .fillMaxWidth()
                        .clip(
                            RoundedCornerShape(
                                bottomStart = 5.dp,
                                bottomEnd = 5.dp
                            )
                        ),  // Redondeo de las esquinas inferiores
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = concert.name,
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(
                        start = 10.dp,
                        top = 5.dp,
                        bottom = 10.dp
                    )  // Añadir padding al inicio (izquierda)
                )
                Text(
                    text = concert.location,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(
                        start = 10.dp,
                        top = 5.dp,
                        bottom = 10.dp
                    )  // Añadir padding al inicio (izquierda)
                )
            }
        }
    }
}