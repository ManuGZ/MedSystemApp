package com.manuel.medsystemapp.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.manuel.medsystemapp.domain.Appointment

@Composable
fun AppointmentScreen(viewModel: AppointmentViewModel, navController: NavHostController) {
    val state = viewModel.state.value

    Scaffold { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF2E3F6E))
                .padding(paddingValues)
        ) {
        Column(
            modifier = Modifier.padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            state.data?.let { appointments ->
                LazyColumn {
                    itemsIndexed(appointments) { _, appointment ->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(4.dp)
                        ) {
                            Column(modifier = Modifier.padding(8.dp)) {
                                Text("ID: ${appointment.id}")
                                Text("Doctor ID: ${appointment.doctorId}")
                                Text("Patient ID: ${appointment.patientId}")
                                Text("Date: ${appointment.date}")
                                Text("Reason: ${appointment.reason}")
                            }
                        }

                    }

                    }
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Button(onClick = {
                        navController.navigate("postAppointment")
                    }) {
                        Text( "Create new appointment")
                    }
                }
                }

            }
            if (state.isLoading) {
                CircularProgressIndicator()
            }
            if (state.message.isNotEmpty()) {
                Text(state.message)
            }

        }

    }

}