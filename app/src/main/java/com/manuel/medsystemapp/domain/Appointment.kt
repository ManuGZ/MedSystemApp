package com.manuel.medsystemapp.domain

data class Appointment(
    val id: Long,
    val doctorId: Long,
    val patientId: Long,
    val date: String,
    val reason: String)
