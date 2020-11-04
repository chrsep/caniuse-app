package dev.chrsep.caniuse.repositories

import dev.chrsep.caniuse.db.EraDao
import dev.chrsep.caniuse.db.model.Era
import dev.chrsep.caniuse.network.CaniuseService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CaniuseRepository @Inject constructor(val service: CaniuseService, val eraDao: EraDao) {
    val getEras = eraDao.getAll()

    suspend fun refreshEra() = withContext(Dispatchers.IO) {
        val newData = service.getAllData()
        eraDao.insert(newData.eras.map {
            Era(it.key, it.value)
        })
    }
}