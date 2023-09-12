package com.example.lab06navigation.navegation.model

sealed class Screen(val route: String) {
    object ConcertsList : Screen("concerts_list")
    object ConcertDetail : Screen("concert_detail/{concertId}")
}




