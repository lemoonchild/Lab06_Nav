package com.example.lab06navigation.ui.profile.viewmodel

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateOf

class UserProfileViewModel : ViewModel() {

    // Estado para el nombre del usuario
    val userName = mutableStateOf("Nahomy Castro")

    // Estado para el switch de notificaciones
    val isNotificationEnabled = mutableStateOf(false)
}
