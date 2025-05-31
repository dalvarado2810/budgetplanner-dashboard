package com.daniel.budgetplanner.dashboard.data.utils

import com.daniel.budgetplanner.dashboard.data.local.entities.MovementEntity
import com.daniel.budgetplanner.dashboard.domain.model.DomainMovements
import com.daniel.budgetplanner.dashboard.domain.model.Movement
import com.daniel.budgetplanner.dashboard.presentation.home.model.MovementItem

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

fun DomainMovements.toPresentationMovements() = this.map { it.toMovementItem() }
