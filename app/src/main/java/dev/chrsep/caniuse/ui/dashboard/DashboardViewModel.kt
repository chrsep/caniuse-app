package dev.chrsep.caniuse.ui.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import dev.chrsep.caniuse.repository.CaniuseRepository
import javax.inject.Inject

class DashboardViewModel @Inject constructor(val caniuseRepository: CaniuseRepository) :
    ViewModel() {
    val data = liveData {
        emit(caniuseRepository.getData())
    }
}