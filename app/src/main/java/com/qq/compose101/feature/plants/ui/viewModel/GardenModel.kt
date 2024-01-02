package com.qq.compose101.feature.plants.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import com.qq.compose101.core.platform.BaseViewModel
import com.qq.compose101.core.usecase.UseCase
import com.qq.compose101.feature.plants.domain.entity.PlantAndGardenPlantings
import com.qq.compose101.feature.plants.domain.usecase.GetGardens
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class GardenModel @Inject constructor(getGardens: GetGardens) : BaseViewModel() {
    val _plantAndGardenPlantings = MutableLiveData<List<PlantAndGardenPlantings>>()
    val plantAndGardenPlantings: LiveData<List<PlantAndGardenPlantings>> get() = _plantAndGardenPlantings

//    init {
//        getGardens.invoke(UseCase.None()) {
//            it.fold(::handleFailure, ::handleGardenList)
//        }
//    }
//
//    fun handleGardenList(plantAndGardenPlantings: Flow<List<PlantAndGardenPlantings>>) {
//        _plantAndGardenPlantings.postValue(plantAndGardenPlantings.asLiveData())
//    }
}