package com.example.lab06navigation.ui.favorites.viewmodel

import androidx.lifecycle.ViewModel
import com.example.lab06navigation.R
import com.example.lab06navigation.ui.concerts.viewmodel.Concert

//Lista de conciertos a mostrar en pantalla de Favoritos
class ConcertPlacesViewModel : ViewModel() {
    fun getFavoritesConcerts(): List<Concert> {
        return listOf(
            Concert("The Home Team", "Los Angeles", R.drawable.concierto, "11/09/2023", "19:00", "Don Broco & The Home Team\nSat • Sep 11 • 7:00 PM\nThe Belasco, Los Angeles, CA"),
            Concert("Bring Me The Horizon", "Utilita Arena Cardiff", R.drawable.concierto2, "23/09/2023", "20:00", "Bring Me The Horizon\nMon • Sep 23 • 8:00 PM\nUtilita Arena Cardiff" ),
            Concert("Three Days Grace", "Chicago", R.drawable.concierto3, "17/10/2023", "17:30", "Three Days Grace\nWed • Oct 17 • 7:00 PM\nChicago"),
            Concert("Dance Gavin Dance", "Salt Lake City", R.drawable.concierto4, "30/10/2023", "18:00", "Dance Gavin Dance\nFri • Oct 30 • 6:00 PM\nSalt Lake City"),
        )
    }
}
