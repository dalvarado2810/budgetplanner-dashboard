package com.daniel.budgetplanner.dashboard.domain.usecases.model

import com.daniel.budgetplanner.dashboard.domain.model.DashboardBalances
import com.daniel.budgetplanner.dashboard.domain.model.DomainMovements

data class DeleteMovementUseCaseResult(
    val actualBalances: DashboardBalances,
    val userMovements: DomainMovements
)
