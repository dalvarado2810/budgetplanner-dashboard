package com.daniel.budgetplanner.dashboard.data.repositories

import com.daniel.budgetplanner.dashboard.data.local.dao.MovementsDao
import com.daniel.budgetplanner.dashboard.data.utils.calculateCategoryBalances
import com.daniel.budgetplanner.dashboard.data.utils.calculateTotalActualBalance
import com.daniel.budgetplanner.dashboard.data.utils.toMovement
import com.daniel.budgetplanner.dashboard.data.utils.toMovementEntity
import com.daniel.budgetplanner.dashboard.domain.model.Category
import com.daniel.budgetplanner.dashboard.domain.model.DashboardBalances
import com.daniel.budgetplanner.dashboard.domain.model.DomainMovements
import com.daniel.budgetplanner.dashboard.domain.model.Movement
import com.daniel.budgetplanner.dashboard.domain.repositories.MovementRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MovementRepositoryImpl(
    private val movementsDao: MovementsDao
) : MovementRepository {
    override fun getActualBalance(
        startDate: String,
        endDate: String,
        userName: String
    ): Flow<DashboardBalances> =
        movementsDao.getAllMonthlyMovementsByUser(
            startDate = startDate,
            endDate = endDate,
            user = userName
        ).map { list ->
            val actualBalance = list.calculateTotalActualBalance()
            val categoryBalancesMap = list.calculateCategoryBalances()

            DashboardBalances(
                actualBalance = actualBalance,
                monthlyIncomeBalance = categoryBalancesMap.getValue(Category.MONTHLY_INCOMES),
                otherIncomesBalance = categoryBalancesMap.getValue(Category.OTHER_INCOMES),
                foodExpensesBalance = categoryBalancesMap.getValue(Category.FOOD_EXPENSES),
                healthExpensesBalance = categoryBalancesMap.getValue(Category.HEALTH_EXPENSES),
                servicesExpensesBalance = categoryBalancesMap.getValue(
                    Category.SERVICES_EXPENSES
                ),
                transportExpensesBalance = categoryBalancesMap.getValue(
                    Category.TRANSPORTATION_EXPENSES
                ),
                outfitExpensesBalance = categoryBalancesMap.getValue(Category.OUTFIT_EXPENSES),
                antExpensesBalance = categoryBalancesMap.getValue(Category.ANT_EXPENSES)
            )
        }

    override fun getMovementsByName(
        startDate: String,
        endDate: String,
        user: String
    ) : Flow<DomainMovements> {
        val movementDbFlow = movementsDao.getAllMonthlyMovements(startDate, endDate)
        return movementDbFlow.map { listOfMovementDb ->
            listOfMovementDb.map {
                it.toMovement()
            }
        }
    }

    override suspend fun addMovementToDb(movement: Movement) =
        movementsDao.addMovement(movement.toMovementEntity())
}
