package com.manuel.medsystemapp.data.remote

import com.google.gson.annotations.SerializedName
import com.manuel.medsystemapp.domain.Appointment

data class AppointmentDto(
    @SerializedName("id")
    val appointmentId: String,
    @SerializedName("doctorId")
    val doctorId: String,
    @SerializedName("patientId")
    val patientId: String,
    @SerializedName("date")
    val appointmentDate: String,
    @SerializedName("reason")
    val description: String,
)

fun AppointmentDto.toAppointment() = Appointment(appointmentId, doctorId, patientId, appointmentDate, description)
