package dev.chrsep.caniuse.repository

import dev.chrsep.caniuse.network.CaniuseService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CaniuseRepository @Inject constructor(val service: CaniuseService) {
    suspend fun getData() = withContext(Dispatchers.IO) {
        service.getAllData()
    }
}