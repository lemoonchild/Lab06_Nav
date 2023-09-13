package com.example.lab06navigation.ui.detail.viewmodel


import androidx.lifecycle.ViewModel
import com.example.lab06navigation.R
import com.example.lab06navigation.ui.concerts.viewmodel.Concert
import com.example.lab06navigation.ui.concerts.viewmodel.ConcertsViewModel.ConcertRepository

class ConcertDetailViewModel : ViewModel() {

    fun getConcertById(concertId: String): Concert? {
        return ConcertRepository.getAllSampleConcerts().firstOrNull { it.name == concertId }
    }

    val concert = Concert(
        "The Home Team",
        "Los Angeles",
        R.drawable.concierto,
        "07/10/2023",
        "19:00",
        "Don Broco & The Home Team\nSat • Oct 07 • 7:00 PM\nThe Belasco, Los Angeles, CA"
    )

}


