package com.qq.compose101.feature.plants.ui.screen.seed

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import com.qq.compose101.feature.plants.ui.model.PlantView
import com.qq.compose101.feature.plants.ui.viewModel.SeedDetailViewModel

@Composable
fun SeedDetailScreen(
    modifier: Modifier = Modifier,
    seedDetailViewModel: SeedDetailViewModel,
    onBackClick: () -> Unit,
    onShareClick: (String) -> Unit,
) {
    val plantView by seedDetailViewModel.plant.collectAsState()
    val isPlanted by seedDetailViewModel.isPlanted.collectAsState()
    val showSnackbar by seedDetailViewModel.showSnackbar.observeAsState()
    SeedDetailScreen(
        modifier = modifier,
        plantView = plantView,
        isPlanted = isPlanted,
        onBackClick = onBackClick,
        onShareClick = onShareClick,
        showSnackBar = showSnackbar
    )
}

@Composable
fun SeedDetailScreen(
    modifier: Modifier = Modifier,
    plantView: PlantView,
    isPlanted: Boolean,
    showSnackBar: Boolean?,
    onBackClick: () -> Unit,
    onShareClick: (String) -> Unit,
) {

}