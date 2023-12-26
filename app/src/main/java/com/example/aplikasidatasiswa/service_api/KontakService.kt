package com.example.aplikasidatasiswa.service_api

import com.example.aplikasidatasiswa.model.Kontak
import retrofit2.http.GET
import retrofit2.http.Headers

interface KontakService {
    @Headers(
        "Accept: application/json"
    )
    @GET("/kontak")
    suspend fun getKontak(): List<Kontak>
}