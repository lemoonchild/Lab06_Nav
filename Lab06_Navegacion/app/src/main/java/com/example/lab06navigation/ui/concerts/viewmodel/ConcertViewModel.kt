package com.example.lab06navigation.ui.concerts.viewmodel

import androidx.lifecycle.ViewModel
import com.example.lab06navigation.R

data class Concert(val name: String, val location: String, val imageRes: Int, val date: String, val time: String, val description: String)

class ConcertsViewModel : ViewModel() {

    object ConcertRepository {

        fun getAllSampleConcerts(): List<Concert> {
            return listOf(
                Concert(
                    "Lauv",
                    "Amsterdam",
                    R.drawable.concierto4,
                    "11/09/2023",
                    "19:00",
                    "Lauv\nSat • Sep 11 • 7:00 PM\nAmsterdam"
                ),
                Concert(
                    "Disturbed",
                    "New York",
                    R.drawable.concierto2,
                    "23/09/2023",
                    "20:00",
                    "Disturbed\nMon • Sep 23 • 8:00 PM\nNew York"
                ),
                Concert(
                    "The Neighbourhood",
                    "Chicago",
                    R.drawable.concierto,
                    "17/10/2023",
                    "17:30",
                    "The Neighbourhood\nWed • Oct 17 • 7:00 PM\nChicago"
                ),
                Concert(
                    "Cuarteto de Nos",
                    "La Concha Acústica",
                    R.drawable.concierto3,
                    "30/10/2023",
                    "18:00",
                    "Cuarteto de Nos\nFri • Oct 30 • 6:00 PM\nLa Concha Acústica"
                ),
            )
        }
    }
}

