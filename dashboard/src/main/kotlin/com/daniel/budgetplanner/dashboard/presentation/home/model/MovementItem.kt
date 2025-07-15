package com.daniel.budgetplanner.dashboard.presentation.home.model

import com.daniel.budgetplanner.dashboard.domain.model.Category

data class MovementItem(
    val name: String,
    val category: Category,
    val date: String,
    val amount: String
)
