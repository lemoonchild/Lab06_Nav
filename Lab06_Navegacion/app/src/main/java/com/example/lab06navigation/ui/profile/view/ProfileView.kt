package com.example.lab06navigation.ui.profile.view

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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab06navigation.R
import com.example.lab06navigation.ui.profile.viewmodel.UserProfileViewModel

@Composable
fun UserProfile(viewModel: UserProfileViewModel) {

    val userName = viewModel.userName.value

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        // Parte superior con la imagen de fondo y el ícono del usuario
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.concierto5), // imagen de fondo
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            Column(
                horizontalAlignment = Alignment.CenterHorizontally // Se centra horizontalmente dentro del Column
            ) {
                Icon(
                    imageVector = Icons.Default.AccountCircle, // Icono de usuario
                    contentDescription = null,
                    modifier = Modifier.size(150.dp), // Tamaño del icono
                    tint = Color.White
                )
                Text(
                    text = userName, // Nombre del usuario dentro del colum
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White // Texto en blanco
                )
            }
        }

        // Bloque blanco con las opciones
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(16.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(30.dp)
            ) {
                ProfileOption(
                    // Elementos de profile
                    icon = Icons.Default.AccountCircle,
                    title = "Edit Profile",
                    trailingIcon = Icons.Default.ArrowDropDown
                )
                ProfileOption(
                    // Elemento de contraseña
                    icon = Icons.Default.Lock,
                    title = "Reset Password",
                    trailingIcon = Icons.Default.ArrowDropDown
                )
                ProfileOption(
                        icon = Icons.Default.Person,
                        title = "Notifications",
                        toggle = viewModel.isNotificationEnabled.value,
                        onToggleChange = { viewModel.isNotificationEnabled.value = it }
                )
                ProfileOption(
                    // Elemento de favoritos
                    icon = Icons.Default.Star,
                    title = "Favorites",
                    trailingIcon = Icons.Default.ArrowDropDown
                )
            }
        }
    }
}

@Composable
fun ProfileOption(
    icon: ImageVector,
    title: String,
    trailingIcon: ImageVector? = null,
    toggle: Boolean = false,
    onToggleChange: ((Boolean) -> Unit)? = null
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(imageVector = icon, contentDescription = null)
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = title, fontSize = 18.sp)
        }
    if (toggle) {
        Switch(
            checked = toggle,
            onCheckedChange = onToggleChange
        )
    } else {
        Icon(
            imageVector = trailingIcon ?: Icons.Default.ArrowDropDown,
            contentDescription = null,
            modifier = Modifier.rotate(180f) // Para qye el triangulo apunte hacia arriba
            )
        }
    }
}



