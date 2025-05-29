package com.daniel.budgetplanner.dashboard.ui.home.screen

import androidx.compose.runtime.Composable
import com.daniel.budgetplanner.dashboard.presentation.home.mvi.Home
import com.daniel.budgetplanner.dashboard.ui.home.view.HomeView

@Composable
fun HomeScreen(
    state: Home.State,
) {
    when (state) {
        is Home.State.Content -> {
            HomeView(
                state = state
            )
        }
        is Home.State.Error -> {}
        is Home.State.Loading -> {}
    }
}
