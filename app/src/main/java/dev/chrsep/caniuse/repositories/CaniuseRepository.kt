package dev.chrsep.caniuse.repositories

import dev.chrsep.caniuse.db.EraDao
import dev.chrsep.caniuse.db.FeatureDao
import dev.chrsep.caniuse.db.model.Era
import dev.chrsep.caniuse.db.model.Feature
import dev.chrsep.caniuse.network.CaniuseService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CaniuseRepository @Inject constructor(
    private val service: CaniuseService,
    private val eraDao: EraDao,
    private val featureDao: FeatureDao
) {
    val getEras = eraDao.getAll()

    suspend fun refreshData() = withContext(Dispatchers.IO) {
        val newData = service.getAllData()
        eraDao.insert(newData.eras.map {
            Era(it.key, it.value)
        })
        featureDao.insert(newData.data.map {
            Feature(it.key, it.value.title, it.value.description)
        })
    }
}