package com.daniel.budgetplanner.dashboard.presentation.movementdialog.model

import com.daniel.budgetplanner.dashboard.domain.model.DbMovementType
import com.daniel.budgetplanner.dashboard.domain.model.Movement
import java.time.LocalDate

data class MovementDialogEditModeData(
    val movementDescription: String,
    val movementAmount: String,
    val dbMovementType: DbMovementType,
    val movementCategory: String,
    val date: LocalDate,
    val movementToEdit: Movement
)
