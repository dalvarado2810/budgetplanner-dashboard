package com.daniel.budgetplanner.dashboard.data.utils

import com.daniel.budgetplanner.dashboard.data.local.entities.MovementEntity
import com.daniel.budgetplanner.dashboard.domain.model.Category
import com.daniel.budgetplanner.dashboard.domain.model.DbMovementType
import kotlin.math.absoluteValue

fun List<MovementEntity>.calculateCategoryBalances(): Map<Category, Int> {
    val categoryBalances = mutableMapOf<Category, Int>().withDefault { 0 }

    this.forEach { item ->
        val currentBalance = categoryBalances.getValue(item.movementCategory)
        val amount = item.movementAmount

        val newBalance = when (item.movementCategory) {
            Category.MONTHLY_INCOMES,
            Category.OTHER_INCOMES -> currentBalance + amount

            Category.FOOD_EXPENSES,
            Category.HEALTH_EXPENSES,
            Category.SERVICES_EXPENSES,
            Category.TRANSPORTATION_EXPENSES,
            Category.OUTFIT_EXPENSES,
            Category.ANT_EXPENSES -> currentBalance + amount
        }
        categoryBalances[item.movementCategory] = newBalance
    }
    return categoryBalances
}

fun List<MovementEntity>.calculateTotalActualBalance(): Int {
    return this.sumOf { item ->
        when (item.movementType) {
            DbMovementType.INCOME -> item.movementAmount
            DbMovementType.EXPENSE -> -item.movementAmount.absoluteValue
        }
    }
}
