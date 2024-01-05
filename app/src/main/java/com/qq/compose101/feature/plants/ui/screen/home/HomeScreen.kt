@file:OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)

package com.qq.compose101.feature.plants.ui.screen.home

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.qq.compose101.R
import com.qq.compose101.core.theme.title
import com.qq.compose101.feature.plants.ui.model.PlantView
import com.qq.compose101.feature.plants.ui.screen.garden.GardenScreen
import com.qq.compose101.feature.plants.ui.screen.seed.SeedListScreen
import com.qq.compose101.feature.plants.ui.viewModel.PlantListViewModel
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onPlantClick: (PlantView) -> Unit = {},
    viewModel: PlantListViewModel = hiltViewModel()
) {
    val pagerState = rememberPagerState() {
        2
    }
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    Scaffold(
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            HomeTopAppBar(
                pagerState = pagerState,
                onFilterClick = { viewModel.updateData() },
                scrollBehavior = scrollBehavior
            )
        }
    ) { contentPadding ->
        HomePagerScreen(
            onPlantClick = onPlantClick,
            pagerState = pagerState,
            Modifier.padding(top = contentPadding.calculateTopPadding())
        )
    }

}

enum class SeedGardenPage(@StringRes val titleResId: Int, @DrawableRes val drawableResId: Int) {
    MY_GARDEN(R.string.title_my_garden, R.drawable.ic_my_garden),
    SEEDS(R.string.title_seeds, R.drawable.ic_seeds),
}

@Composable
fun HomeTopAppBar(
    pagerState: PagerState,
    onFilterClick: () -> Unit,
    scrollBehavior: TopAppBarScrollBehavior,
    modifier: Modifier = Modifier
) {
    CenterAlignedTopAppBar(
        title = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(id = R.string.app_name),
                    style = MaterialTheme.typography.title
                )
            }
        },
        modifier = modifier,
        actions = {
            if (pagerState.currentPage == SeedGardenPage.SEEDS.ordinal) {
                IconButton(onClick = onFilterClick) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_filter_list_24dp),
                        contentDescription = null
                    )
                }
            }
        }

    )
}

@Composable
fun HomePagerScreen(
    onPlantClick: (PlantView) -> Unit,
    pagerState: PagerState,
    modifier: Modifier = Modifier,
    pages: Array<SeedGardenPage> = SeedGardenPage.entries.toTypedArray()
) {
    Column(modifier) {
        val coroutineScope = rememberCoroutineScope()
        TabRow(selectedTabIndex = pagerState.currentPage) {
            pages.forEachIndexed { index, page ->
                val title = stringResource(id = page.titleResId)
                Tab(
                    selected = pagerState.currentPage == index,
                    onClick = { coroutineScope.launch { pagerState.animateScrollToPage(index) } },
                    text = { Text(text = title) },
                    icon = {
                        Icon(
                            painter = painterResource(id = page.drawableResId),
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.onPrimary
                        )
                    }
                )
            }
        }

        HorizontalPager(
            modifier = Modifier.background(MaterialTheme.colorScheme.background),
            state = pagerState,
            verticalAlignment = Alignment.Top
        ) { index ->
            when (pages[index]) {
                SeedGardenPage.MY_GARDEN -> {
                    GardenScreen(
                        modifier = Modifier.fillMaxWidth(),
                        onAddPlantClick = {
                            coroutineScope.launch {
                                pagerState.scrollToPage(SeedGardenPage.SEEDS.ordinal)
                            }
                        }, onPlantClick = { onPlantClick(it.plantView) })
                }

                SeedGardenPage.SEEDS -> {
                    SeedListScreen(onPlantClick = onPlantClick, modifier = Modifier.fillMaxWidth())
                }
            }
        }
    }
}