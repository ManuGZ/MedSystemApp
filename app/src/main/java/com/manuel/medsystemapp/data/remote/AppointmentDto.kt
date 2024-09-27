package com.manuel.medsystemapp.data.remote

import com.manuel.medsystemapp.domain.Appointment

data class AppointmentDto (
    val id: Long,
    val doctorId: Long,
    val patientId: Long,
    val date: String,
    val reason: String,
)

fun AppointmentDto.toAppointment() = Appointment(id, doctorId, patientId, date, reason)