package com.daniel.budgetplanner.dashboard.data.utils

import com.daniel.budgetplanner.dashboard.data.local.entities.MovementEntity
import com.daniel.budgetplanner.dashboard.domain.model.Category
import com.daniel.budgetplanner.dashboard.domain.model.DbMovementType
import com.daniel.budgetplanner.dashboard.domain.model.Movement
import com.daniel.budgetplanner.dashboard.navigation.DashboardDestination
import com.daniel.budgetplanner.dashboard.presentation.home.model.MovementItem
import com.daniel.budgetplanner.dashboard.presentation.movementdialog.model.MovementDialogData
import com.daniel.budgetplanner.dashboard.presentation.movementdialog.model.MovementDialogEditModeData
import com.daniel.budgetplanner.dashboard.utils.INCOME
import java.time.LocalDate

fun Movement.toMovementEntity() = MovementEntity(
    id = id,
    movementDescription = movementDescription,
    movementAmount = movementAmount,
    movementType = dbMovementType,
    movementUser = movementUser,
    movementCategory = movementCategory,
    date = date,
    month = month,
    year = year
)

fun MovementEntity.toMovement() = Movement(
    id = id,
    movementDescription = movementDescription,
    movementAmount = movementAmount,
    dbMovementType = movementType,
    movementUser = movementUser,
    movementCategory = movementCategory,
    date = date,
    month = month,
    year = year
)

fun Movement.toMovementItem() = MovementItem(
    name = movementDescription,
    category = movementCategory,
    date = obtainDateFormatted(),
    amount = movementAmount.toString()
)

fun MovementDialogData.toMovement(username: String) = Movement(
    id = 0,
    movementDescription = movementDescription,
    movementAmount = movementAmount.toInt(),
    dbMovementType = dbMovementType,
    movementUser = username,
    movementCategory = movementCategory.toCategory(),
    date = date,
    month = date.monthValue,
    year = date.year
)

fun MovementDialogEditModeData.toMovement(username: String) = Movement(
    id = movementToEdit.id,
    movementDescription = movementDescription,
    movementAmount = movementAmount.toInt(),
    dbMovementType = dbMovementType,
    movementUser = username,
    movementCategory = movementCategory.toCategory(),
    date = date,
    month = date.monthValue,
    year = date.year
)

fun String.toCategory(): Category {
    return when(this) {
        "Alimentación" -> Category.FOOD_EXPENSES
        "Gastos hormiga" -> Category.ANT_EXPENSES
        "Servicios" -> Category.SERVICES_EXPENSES
        "Salud" -> Category.HEALTH_EXPENSES
        "Vestimenta" -> Category.OUTFIT_EXPENSES
        "Transporte" -> Category.TRANSPORTATION_EXPENSES
        "Ingresos Mensuales" -> Category.MONTHLY_INCOMES
        else -> Category.OTHER_INCOMES
    }
}

fun String.toDbMovementType() = when(this){
    INCOME -> DbMovementType.INCOME
    else -> DbMovementType.EXPENSE
}

fun DashboardDestination.MovementDialog.toMovement() = Movement(
    id = id,
    movementDescription = movementDescription,
    movementAmount = movementAmount,
    dbMovementType = dbMovementType.toDbMovementType(),
    movementCategory = movementCategory.toCategory(),
    movementUser = movementUser,
    date = LocalDate.of(year, month, day),
    month = month,
    year = year
)
