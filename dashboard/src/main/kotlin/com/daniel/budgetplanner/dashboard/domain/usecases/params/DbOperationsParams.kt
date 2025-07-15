package com.daniel.budgetplanner.dashboard.domain.usecases.params

import com.daniel.budgetplanner.dashboard.domain.model.Movement

data class DbOperationsParams(
    val userName: String,
    val rangeDates: Pair<String, String>,
    val movement: Movement
)
