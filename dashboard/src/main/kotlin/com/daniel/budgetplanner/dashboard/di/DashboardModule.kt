package com.daniel.budgetplanner.dashboard.di

import com.daniel.budgetplanner.dashboard.presentation.home.action.InitActionProcessor
import com.daniel.budgetplanner.dashboard.presentation.home.action.OnToggleVisibilityActionProcessor
import com.daniel.budgetplanner.dashboard.presentation.home.viewmodel.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val dashboardModule = module {
    // ViewModel
    viewModelOf(::HomeViewModel)

    // Action Processors
    factoryOf(::InitActionProcessor)
    factoryOf(::OnToggleVisibilityActionProcessor)

    // Use Cases
}
