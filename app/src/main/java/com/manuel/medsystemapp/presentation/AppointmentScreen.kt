package com.manuel.medsystemapp.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.unit.dp
import com.manuel.medsystemapp.domain.Appointment

@Composable
fun AppointmentScreen(viewModel: AppointmentViewModel) {
    val state = viewModel.state.value

    var doctorId by remember { mutableStateOf("") }
    var patientId by remember { mutableStateOf("") }
    var date by remember { mutableStateOf("") }
    var reason by remember { mutableStateOf("") }

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

            // Input fields for new appointment
            OutlinedTextField(
                value = doctorId,
                onValueChange = { doctorId = it },
                label = { Text("Doctor ID") },
                modifier = Modifier.fillMaxWidth().padding(8.dp)
            )
            OutlinedTextField(
                value = patientId,
                onValueChange = { patientId = it },
                label = { Text("Patient ID") },
                modifier = Modifier.fillMaxWidth().padding(8.dp)
            )
            OutlinedTextField(
                value = date,
                onValueChange = { date = it },
                label = { Text("Date") },
                modifier = Modifier.fillMaxWidth().padding(8.dp)
            )
            OutlinedTextField(
                value = reason,
                onValueChange = { reason = it },
                label = { Text("Reason") },
                modifier = Modifier.fillMaxWidth().padding(8.dp)
            )

            // Button to create a new appointment
            Button(onClick = {
                val newAppointment = Appointment(
                    id = 0L, // or generate a new ID
                    doctorId = doctorId.toLongOrNull() ?: 0L,
                    patientId = patientId.toLongOrNull() ?: 0L,
                    date = date,
                    reason = reason
                )
                viewModel.postAppointment(newAppointment)
            }) {
                Text("Create Appointment")
            }

        }
    }
}