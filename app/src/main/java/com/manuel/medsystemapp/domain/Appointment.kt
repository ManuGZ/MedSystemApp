package com.manuel.medsystemapp.domain

data class Appointment(
    val id: String,
    val doctorId: String,
    val patientId: String,
    val date: String,
    val reason: String,
)
