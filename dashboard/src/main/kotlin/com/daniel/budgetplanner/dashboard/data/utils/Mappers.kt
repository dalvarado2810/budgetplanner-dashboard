package com.daniel.budgetplanner.dashboard.data.utils

import com.daniel.budgetplanner.dashboard.data.local.entities.MovementEntity
import com.daniel.budgetplanner.dashboard.domain.model.Category
import com.daniel.budgetplanner.dashboard.domain.model.DomainMovements
import com.daniel.budgetplanner.dashboard.domain.model.Movement
import com.daniel.budgetplanner.dashboard.presentation.home.model.MovementItem
import com.daniel.budgetplanner.dashboard.presentation.movementdialog.model.MovementDialogData

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

fun DomainMovements.toPresentationMovements() = this.map { it.toMovementItem() }
