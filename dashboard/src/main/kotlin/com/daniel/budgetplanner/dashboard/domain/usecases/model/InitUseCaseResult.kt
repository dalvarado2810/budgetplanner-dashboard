package com.daniel.budgetplanner.dashboard.domain.usecases.model

import com.daniel.budgetplanner.dashboard.domain.model.DashboardBalances
import com.daniel.budgetplanner.dashboard.domain.model.PresentationMovements

data class InitUseCaseResult(
    val userName: String,
    val rangeOfDates: Pair<String, String>,
    val actualBalances: DashboardBalances,
    val userMovements: PresentationMovements
)
