package com.qq.compose101.feature.plants.ui.viewModel

import com.qq.compose101.core.platform.BaseViewModel
import com.qq.compose101.feature.plants.domain.usecase.CreateGarden
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
@HiltViewModel
class SeedDetailViewModel @Inject constructor(
    createGarden: CreateGarden
) : BaseViewModel() {


}