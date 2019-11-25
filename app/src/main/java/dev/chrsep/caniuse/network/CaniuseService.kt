package dev.chrsep.caniuse.network

import retrofit2.http.GET

interface CaniuseService {
    @GET("data.json")
    suspend fun getAllData(): CaniuseData;
}