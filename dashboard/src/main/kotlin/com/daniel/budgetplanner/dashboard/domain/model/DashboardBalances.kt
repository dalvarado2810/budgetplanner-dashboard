package com.daniel.budgetplanner.dashboard.domain.model

data class DashboardBalances(
    val actualBalance: Int = 0,
    val monthlyIncomeBalance: Int = 0,
    val otherIncomesBalance: Int = 0,
    val foodExpensesBalance: Int = 0,
    val healthExpensesBalance: Int = 0,
    val servicesExpensesBalance: Int = 0,
    val transportExpensesBalance: Int = 0,
    val outfitExpensesBalance: Int = 0,
    val antExpensesBalance: Int = 0
)
