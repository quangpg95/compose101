package com.qq.compose101.feature.plants.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.qq.compose101.core.platform.BaseViewModel
import com.qq.compose101.feature.app.Screen.Companion.KEY_PLANT_ID
import com.qq.compose101.feature.plants.domain.entity.Plant
import com.qq.compose101.feature.plants.domain.usecase.CheckPlanted
import com.qq.compose101.feature.plants.domain.usecase.CreateGarden
import com.qq.compose101.feature.plants.domain.usecase.GetPlan
import com.qq.compose101.feature.plants.ui.model.PlantView
import com.qq.compose101.feature.plants.ui.model.toDisplay
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SeedDetailViewModel @Inject constructor(
    private val createGarden: CreateGarden,
    getPlan: GetPlan,
    checkPlanted: CheckPlanted,
    savedStateHandle: SavedStateHandle
) : BaseViewModel() {
    // savedStateHandle can get param from NavBackStackEntry, sure that KEY_PLANT_ID value is same with param of
    private val planId: String = checkNotNull(savedStateHandle[KEY_PLANT_ID])

    private val _plant: MutableStateFlow<PlantView> = MutableStateFlow(PlantView())
    val plant: StateFlow<PlantView> get() = _plant

    private val _isPlanted: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val isPlanted: StateFlow<Boolean> get() = _isPlanted

    private val _showSnackbar = MutableLiveData(false)
    val showSnackbar: LiveData<Boolean>
        get() = _showSnackbar

    init {
        getPlan.invoke(planId) {
            it.fold(::handleFailure, ::handleGetPlan)
        }
        checkPlanted.invoke(planId) {
            it.fold(::handleFailure, ::handleCheckPlanted)
        }
    }

    private fun handleCheckPlanted(isPlantedFlow: Flow<Boolean>) {
        viewModelScope.launch {
            isPlantedFlow.collectLatest {
                _isPlanted.value = it
            }
        }
    }

    private fun handleGetPlan(plant: Flow<Plant>) {
        viewModelScope.launch {
            plant.collectLatest {
                _plant.value = it.toDisplay()
            }
        }
    }

    fun addPlantToGarden() {
        createGarden.invoke(planId) {
            it.fold(::handleFailure, ::handleAddPlantToGarden)
        }
    }

    private fun handleAddPlantToGarden(id: Long) {
        _showSnackbar.value = true
    }

    fun dismissSnackbar() {
        _showSnackbar.value = false
    }
}