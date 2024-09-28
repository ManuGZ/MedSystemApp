package com.manuel.medsystemapp.data.remote

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface AppointmentService {
    @GET("api/v1/appointments")
    suspend fun getAppointments(): Response<List<AppointmentDto>>
    @POST("api/v1/appointments")
    suspend fun postAppointment(@Body appointmentDto: AppointmentDto): Response<AppointmentDto>
}

