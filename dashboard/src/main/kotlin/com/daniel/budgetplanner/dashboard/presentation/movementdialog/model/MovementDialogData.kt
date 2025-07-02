package com.daniel.budgetplanner.dashboard.presentation.movementdialog.model

import com.daniel.budgetplanner.dashboard.domain.model.DbMovementType
import java.time.LocalDate

data class MovementDialogData(
    val movementDescription: String,
    val movementAmount: String,
    val dbMovementType: DbMovementType,
    val movementCategory: String,
    val date: LocalDate
)
