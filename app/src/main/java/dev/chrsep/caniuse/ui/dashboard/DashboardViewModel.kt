package dev.chrsep.caniuse.ui.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import dev.chrsep.caniuse.repository.CaniuseRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class DashboardViewModel @Inject constructor(val repo: CaniuseRepository) : ViewModel() {
    val eras = repo.getEras.asLiveData(Dispatchers.IO)

    fun refreshData() = viewModelScope.launch {
        repo.refreshEra()
    }
}