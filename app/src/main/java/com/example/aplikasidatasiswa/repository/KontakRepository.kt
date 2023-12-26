package com.example.aplikasidatasiswa.repository

import com.example.aplikasidatasiswa.model.Kontak
import com.example.aplikasidatasiswa.service_api.KontakService

interface KontakRepository {
    /* Fetches List of Kontak from KontakAPI*/
    suspend fun getKontak(): List<Kontak>
}
class NetworkKontakRepository(
    private val kontakApiService: KontakService
) : KontakRepository {
    /* Fetches List of Kontak from KontakAPI*/
    override suspend fun getKontak(): List<Kontak> = kontakApiService.getKontak()
 }
