package com.example.lab06navigation


import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lab06navigation.navegation.model.Screen
import com.example.lab06navigation.ui.theme.Lab06NavigationTheme
import com.example.lab06navigation.ui.concerts.view.DisplayConcerts
import com.example.lab06navigation.ui.detail.view.ConcertDetail
import com.example.lab06navigation.ui.favorites.view.ConcertPlacesList
import com.example.lab06navigation.ui.profile.viewmodel.UserProfileViewModel

@Composable
fun AppNavigator() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = Screen.ConcertsList.route) {
        composable(Screen.ConcertsList.route) {
            DisplayConcerts(navController)
        }
        composable(Screen.ConcertDetail.route + "/{concertId}") { backStackEntry ->
            val concertId = backStackEntry.arguments?.getString("concertId")

            if (concertId != null) {
                ConcertDetail(concertId)
            }

        }
    }
}

class MainActivity : ComponentActivity() {

    private val userProfileViewModel = UserProfileViewModel()

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab06NavigationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //AppNavigator() - PARA EL NAVIGATION DE CARDS Y DETAIL
                    //UserProfile(userProfileViewModel) - PANTALLA DE PERFIL
                    ConcertPlacesList()
                }
            }
        }
    }
}














