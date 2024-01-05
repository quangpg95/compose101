package com.qq.compose101.feature.plants.ui.viewModel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.qq.compose101.core.platform.BaseViewModel
import com.qq.compose101.feature.plants.domain.entity.Plant
import com.qq.compose101.feature.plants.domain.usecase.GetPlants
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
class PlantListViewModel @Inject constructor(
    private val getPlants: GetPlants,
    private val savedStateHandle: SavedStateHandle
) : BaseViewModel() {

    companion object {
        private const val NO_GROW_ZONE = -1
        private const val GROW_ZONE_SAVED_STATE_KEY = "GROW_ZONE_SAVED_STATE_KEY"
    }

    private val growZone: MutableStateFlow<Int> = MutableStateFlow(
        savedStateHandle[GROW_ZONE_SAVED_STATE_KEY] ?: NO_GROW_ZONE
    )

    private val _plants = MutableStateFlow<List<PlantView>>(emptyList())
    val plants: StateFlow<List<PlantView>> get() = _plants


    init {
        viewModelScope.launch {
            growZone.collect { newGrowZone ->
                savedStateHandle[GROW_ZONE_SAVED_STATE_KEY] = newGrowZone
                getPlants.invoke(newGrowZone) {
                    it.fold(::handleFailure, ::handlePlantList)
                }
            }
        }
    }

    private fun handlePlantList(plants: Flow<List<Plant>>) {
        viewModelScope.launch {
            plants.collectLatest {
                _plants.value = it.map { it.toDisplay() }
            }
        }
    }

    fun updateData() {
        if (isFiltered()) {
            clearGrowZoneNumber()
        } else {
            setGrowZoneNumber(9)
        }
    }

    fun setGrowZoneNumber(num: Int) {
        growZone.value = num
    }

    fun clearGrowZoneNumber() {
        growZone.value = NO_GROW_ZONE
    }

    fun isFiltered() = growZone.value != NO_GROW_ZONE


}