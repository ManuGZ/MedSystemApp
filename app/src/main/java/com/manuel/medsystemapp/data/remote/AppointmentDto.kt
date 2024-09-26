package com.manuel.medsystemapp.data.remote

import com.google.gson.annotations.SerializedName

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
