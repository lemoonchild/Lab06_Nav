package com.example.lab06navigation


import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.lab06navigation.navegation.model.Screen
import com.example.lab06navigation.navegation.model.TabScreen
import com.example.lab06navigation.ui.theme.Lab06NavigationTheme
import com.example.lab06navigation.ui.concerts.view.DisplayConcerts
import com.example.lab06navigation.ui.detail.view.ConcertDetail
import com.example.lab06navigation.ui.favorites.view.ConcertPlacesList
import com.example.lab06navigation.ui.profile.view.UserProfile
import com.example.lab06navigation.ui.profile.viewmodel.UserProfileViewModel

@Composable
fun AppNavigator(navController: NavHostController) {

    NavHost(navController, startDestination = TabScreen.Navigator.route) {
        composable(TabScreen.Navigator.route) {
            DisplayConcerts(navController)
        }
        composable(TabScreen.UserProfile.route){
            UserProfile(navController)
        }
        composable(TabScreen.ConcertPlaces.route){
            ConcertPlacesList(navController)
        }
        composable(Screen.ConcertDetail.route + "/{concertId}") { backStackEntry ->
            val concertId = backStackEntry.arguments?.getString("concertId")

            if (concertId != null) {
                ConcertDetail(concertId, navController)
            }

        }
    }
}

@Composable
fun TabNavigations(navController: NavController) {
    val currentRoute = currentRoutes(navController)
    val TabScreens =listOf(TabScreen.Navigator, TabScreen.UserProfile, TabScreen.ConcertPlaces)

    TabRow(selectedTabIndex = TabScreens.indexOfFirst { it.route == currentRoute }.takeIf { it >= 0 } ?: 0){

        TabScreens.forEach { screen ->
            Tab(
                text = { Text(screen.title, color = Color.Black)},
                selected = currentRoute == screen.route,
                onClick = {
                    navController.navigate(screen.route){
                        popUpTo(TabScreen.Navigator.route)
                        launchSingleTop = true
                    }
                }

            )
        }
    }

}

@Composable
fun currentRoutes(navController: NavController): String?{
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route
}

@Composable
fun ScreensContent(){
    val navController: NavHostController = rememberNavController()
    Column() {
        TabNavigations(navController)
        AppNavigator(navController)
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
                    ScreensContent()
                }
            }
        }
    }
}















