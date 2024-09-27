package com.manuel.medsystemapp.data.remote

import retrofit2.Response
import retrofit2.http.GET

interface AppointmentService {
    @GET("api/v1/appointments")
    suspend fun getAppointments(): Response<List<AppointmentDto>>
}

