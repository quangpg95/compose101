package com.qq.compose101.feature.plants.ui.viewModel

import androidx.lifecycle.ViewModel
import com.qq.compose101.feature.plants.domain.usecase.GetPlants
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PlantListViewModel @Inject constructor(private val getPlants: GetPlants) : ViewModel() {


}