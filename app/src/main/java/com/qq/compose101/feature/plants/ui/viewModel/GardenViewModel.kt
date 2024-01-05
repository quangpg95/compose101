package com.qq.compose101.feature.plants.ui.viewModel

import androidx.lifecycle.viewModelScope
import com.qq.compose101.core.platform.BaseViewModel
import com.qq.compose101.core.usecase.UseCase
import com.qq.compose101.feature.plants.domain.entity.PlantAndGardenPlantings
import com.qq.compose101.feature.plants.domain.usecase.GetGardens
import com.qq.compose101.feature.plants.ui.model.PlantAndGardenPlantingsView
import com.qq.compose101.feature.plants.ui.model.toDisplay
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GardenViewModel @Inject constructor(getGardens: GetGardens) : BaseViewModel() {
    private val _gardenPlantingState =
        MutableStateFlow<List<PlantAndGardenPlantingsView>>(emptyList())
    val gardenPlantingState: StateFlow<List<PlantAndGardenPlantingsView>> get() = _gardenPlantingState

    init {
        getGardens.invoke(UseCase.None()) {
            it.fold(::handleFailure, ::handleGardenList)
        }
    }

    private fun handleGardenList(plantAndGardenPlantings: Flow<List<PlantAndGardenPlantings>>) {
        viewModelScope.launch {
            plantAndGardenPlantings.collectLatest {
                _gardenPlantingState.value = it.map { it.toDisplay() }
            }
        }
    }
}