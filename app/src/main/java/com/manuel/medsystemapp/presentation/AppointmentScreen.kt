package com.manuel.medsystemapp.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AppointmentScreen(viewModel: AppointmentViewModel) {
    val state = viewModel.state.value
    Scaffold { paddingValues ->
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