package com.manuel.medsystemapp.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.manuel.medsystemapp.domain.Appointment
import androidx.compose.ui.focus.onFocusChanged

@Composable
fun PostAppointmentScreen(viewModel: AppointmentViewModel, navController: NavHostController) {
    var doctorId by remember { mutableStateOf("") }
    var patientId by remember { mutableStateOf("") }
    var date by remember { mutableStateOf("") }
    var reason by remember { mutableStateOf("") }

    var isDoctorIdFocused  by remember { mutableStateOf(false) }
    var isPatientIdFocused  by remember { mutableStateOf(false) }
    var isDateIdFocused  by remember { mutableStateOf(false) }
    var isReasonIdFocused  by remember { mutableStateOf(false) }

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

                OutlinedTextField(
                    value = doctorId,
                    onValueChange = { doctorId = it },
                    label = {
                        Text(
                            "Doctor ID",
                            color = if (isDoctorIdFocused) Color.White else Color.Black
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .onFocusChanged { focusState -> isDoctorIdFocused = focusState.isFocused },
                    colors = TextFieldDefaults.colors(
                        unfocusedContainerColor = Color.White,
                        focusedContainerColor = Color.White
                    ),
                )
                OutlinedTextField(
                    value = patientId,
                    onValueChange = { patientId = it },
                    label = {
                        Text(
                            "Patient ID",
                            color = if (isPatientIdFocused) Color.White else Color.Black
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .onFocusChanged { focusState -> isPatientIdFocused = focusState.isFocused },
                    colors = TextFieldDefaults.colors(
                        unfocusedContainerColor = Color.White,
                        focusedContainerColor = Color.White
                    ),
                )
                OutlinedTextField(
                    value = date,
                    onValueChange = { date = it },
                    label = {
                        Text(
                            "Date",
                            color = if (isDateIdFocused) Color.White else Color.Black
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .onFocusChanged { focusState -> isDateIdFocused = focusState.isFocused },
                    colors = TextFieldDefaults.colors(
                        unfocusedContainerColor = Color.White,
                        focusedContainerColor = Color.White
                    ),
                )
                OutlinedTextField(
                    value = reason,
                    onValueChange = { reason = it },
                    label = {
                        Text(
                            "Reason",
                            color = if (isReasonIdFocused) Color.White else Color.Black
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .onFocusChanged { focusState -> isReasonIdFocused = focusState.isFocused },
                    colors = TextFieldDefaults.colors(
                        unfocusedContainerColor = Color.White,
                        focusedContainerColor = Color.White
                    ),
                )

                // Button to create a new appointment
                Button(onClick = {
                    val newAppointment = Appointment(
                        id = 0L,
                        doctorId = doctorId.toLongOrNull() ?: 0L,
                        patientId = patientId.toLongOrNull() ?: 0L,
                        date = date,
                        reason = reason
                    )
                    viewModel.postAppointment(newAppointment)
                    navController.popBackStack()
                }) {
                    Text("Create Appointment")
                }

                Button(onClick = {
                    navController.navigate("getAppointments")
                }) {
                    Text("Back to Appointments")
                }
            }
        }
    }

}