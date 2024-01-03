package com.qq.compose101.feature.plants.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.qq.compose101.core.platform.BaseViewModel
import com.qq.compose101.core.usecase.UseCase
import com.qq.compose101.feature.plants.domain.entity.Plant
import com.qq.compose101.feature.plants.domain.entity.PlantAndGardenPlantings
import com.qq.compose101.feature.plants.domain.usecase.GetPlants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlantListViewModel @Inject constructor(private val getPlants: GetPlants) : BaseViewModel() {
    private val _plants = MutableStateFlow<List<Plant>>(emptyList())
    val plants: StateFlow<List<Plant>> get() = _plants

    init {
        getPlants.invoke(UseCase.None()) {
            it.fold(::handleFailure, ::handlePlantList)
        }
    }

    private fun handlePlantList(plants: Flow<List<Plant>>) {
        viewModelScope.launch {
            plants.collectLatest {
                _plants.value = it
            }
        }
    }


}