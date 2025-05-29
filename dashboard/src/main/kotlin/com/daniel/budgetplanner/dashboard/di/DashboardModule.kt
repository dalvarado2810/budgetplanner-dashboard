package com.daniel.budgetplanner.dashboard.di

import com.daniel.budgetplanner.dashboard.presentation.home.viewmodel.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val dashboardModule = module {
    // ViewModel
    viewModelOf(::HomeViewModel)

}
