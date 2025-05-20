package com.example.amphibiansapp.repository

import com.example.amphibiansapp.model.Amphibian
import com.example.amphibiansapp.network.AmphibianApiService
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class AmphibianRepository {
    private val baseUrl = "https://android-kotlin-fun-mars-server.appspot.com/"
    
    private val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
        
    private val apiService: AmphibianApiService = retrofit.create(AmphibianApiService::class.java)
    
    suspend fun getAmphibians(): List<Amphibian> {
        return apiService.getAmphibians()
    }
} 