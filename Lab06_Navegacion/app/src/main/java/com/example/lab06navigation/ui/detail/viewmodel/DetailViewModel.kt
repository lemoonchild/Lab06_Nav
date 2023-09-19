package com.example.lab06navigation.ui.detail.viewmodel


import androidx.lifecycle.ViewModel
import com.example.lab06navigation.R
import com.example.lab06navigation.ui.concerts.viewmodel.Concert
import com.example.lab06navigation.ui.concerts.viewmodel.ConcertsViewModel.ConcertRepository

//Obtener la informacion de los conciertos para la pantalla de detalles
class ConcertDetailViewModel : ViewModel() {
    fun getConcertById(concertId: String): Concert? {
        return ConcertRepository.getAllSampleConcerts().firstOrNull { it.name == concertId }
    }

}


