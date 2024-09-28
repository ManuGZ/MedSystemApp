package com.manuel.medsystemapp;

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.manuel.medsystemapp.common.Constants
import com.manuel.medsystemapp.data.remote.AppointmentService
import com.manuel.medsystemapp.data.repository.AppointmentRepository
import com.manuel.medsystemapp.presentation.AppointmentViewModel
import com.manuel.medsystemapp.presentation.AppointmentScreen
import com.manuel.medsystemapp.presentation.PostAppointmentScreen
import com.manuel.medsystemapp.ui.theme.MedSystemAppTheme
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        val service = Retrofit
            .Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AppointmentService::class.java)

        val viewModel = AppointmentViewModel(AppointmentRepository(service))

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MedSystemAppTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "getAppointments") {
                    composable("getAppointments") { AppointmentScreen (viewModel, navController) }
                    composable("postAppointment") { PostAppointmentScreen (viewModel, navController)}
                }
            }
        }
    }
}