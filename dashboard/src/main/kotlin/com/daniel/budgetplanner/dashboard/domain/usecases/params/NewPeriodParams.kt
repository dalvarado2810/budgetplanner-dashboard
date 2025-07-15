package com.daniel.budgetplanner.dashboard.domain.usecases.params

import java.time.LocalDate

data class NewPeriodParams(
    val startDate: LocalDate?,
    val endDate: LocalDate?
)
