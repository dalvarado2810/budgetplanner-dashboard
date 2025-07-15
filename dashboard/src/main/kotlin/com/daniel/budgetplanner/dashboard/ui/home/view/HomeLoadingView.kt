package com.daniel.budgetplanner.dashboard.ui.home.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.daniel.base.ui.theme.OnboardingBackground
import com.daniel.budgetplanner.dashboard.ui.home.components.LoadingAnimationComponent

@Composable
fun HomeLoadingView() {
    Column(
        modifier = Modifier
            .background(OnboardingBackground)
            .fillMaxSize()
    ) {
        LoadingAnimationComponent()
    }
}

@Preview
@Composable
fun HomeLoadingViewPreview(){
    HomeLoadingView()
}
