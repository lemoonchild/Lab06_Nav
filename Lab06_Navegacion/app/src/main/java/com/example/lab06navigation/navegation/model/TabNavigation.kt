package com.example.lab06navigation.navegation.model

sealed class TabScreen(val route: String, val title: String) {
    object Navigator : TabScreen("concerts", "Concerts")
    object UserProfile : TabScreen("userProfile", "Profile")
    object ConcertPlaces : TabScreen("favorite", "Favorite")
}

