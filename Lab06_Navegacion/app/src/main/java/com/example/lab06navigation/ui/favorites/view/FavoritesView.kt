package com.example.lab06navigation.ui.favorites.view

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.lab06navigation.ui.concerts.viewmodel.Concert
import com.example.lab06navigation.ui.favorites.viewmodel.ConcertPlacesViewModel

@Composable
fun ConcertPlacesList(viewModel: ConcertPlacesViewModel = viewModel()) {
    // Observamos los datos del ViewModel
    val concerts = viewModel.getFavoritesConcerts()

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        // Header con el título "Your Favorites" y el ícono de estrella
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Your Favorites", fontWeight = FontWeight.Bold, fontSize = 20.sp)
            Icon(imageVector = Icons.Default.Star, contentDescription = null, tint = Color.Black)
        }

        Spacer(modifier = Modifier.height(10.dp))

        // Lista de conciertos
        LazyColumn(
            contentPadding = PaddingValues(10.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            items(concerts) { concert ->
                ConcertBlock(concert)

                Spacer(modifier = Modifier.height(15.dp))

            }
        }
    }
}

@Composable
fun ConcertBlock(concert: Concert) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Start
    ) {
        // Imagen del concierto
        Image(
            painter = painterResource(id = concert.imageRes),
            contentDescription = null,
            modifier = Modifier
                .size(70.dp) // Aumentar el tamaño de la imagen
                .align(Alignment.CenterVertically)
        )

        Spacer(modifier = Modifier.width(10.dp))

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .align(Alignment.CenterVertically)
        ) {
            Text(
                text = concert.name,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
            Text(
                text = concert.location,
                fontSize = 16.sp
            )
        }

        Icon(
            imageVector = Icons.Default.KeyboardArrowUp,
            contentDescription = null,
            modifier = Modifier
                .size(20.dp)
                .align(Alignment.CenterVertically)
        )

        Spacer(modifier = Modifier.width(16.dp))
    }
    // Mover la línea fuera de la fila para que cubra toda la parte inferior
    Divider(
        color = Color.Gray,
        thickness = 1.dp,
        modifier = Modifier.fillMaxWidth().padding(top = 8.dp)
    )
}

