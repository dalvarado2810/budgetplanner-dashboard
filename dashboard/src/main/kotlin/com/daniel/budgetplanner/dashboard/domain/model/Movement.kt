package com.daniel.budgetplanner.dashboard.domain.model

import java.time.LocalDate
import java.time.format.DateTimeFormatter

data class Movement(
    val id: Int,
    val movementDescription: String,
    val movementAmount: Int,
    val dbMovementType: DbMovementType,
    val movementUser: String,
    val movementCategory: Category,
    val date: LocalDate,
    val month: Int,
    val year: Int
) {
    fun obtainDateFormatted(): String = date
        .format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
}
