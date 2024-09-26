package com.manuel.medsystemapp.data.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface AppointmentService {

    @Headers("Accept: application/json")
    @GET("/appointments")
    suspend fun getAppointments(): Response<List<AppointmentDto>>
}