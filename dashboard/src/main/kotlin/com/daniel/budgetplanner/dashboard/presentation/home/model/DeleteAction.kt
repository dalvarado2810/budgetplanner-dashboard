package com.daniel.budgetplanner.dashboard.presentation.home.model

import com.daniel.budgetplanner.dashboard.domain.model.Movement

data class DeleteAction(
    val movement: Movement,
    val userName: String,
    val rangeOfDate: Pair<String, String>
)
