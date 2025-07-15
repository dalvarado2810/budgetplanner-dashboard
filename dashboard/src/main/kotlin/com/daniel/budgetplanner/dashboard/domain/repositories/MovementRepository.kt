package com.daniel.budgetplanner.dashboard.domain.repositories

import com.daniel.budgetplanner.dashboard.domain.model.DashboardBalances
import com.daniel.budgetplanner.dashboard.domain.model.DomainMovements
import com.daniel.budgetplanner.dashboard.domain.model.Movement
import kotlinx.coroutines.flow.Flow

interface MovementRepository {
    fun getActualBalance(startDate: String, endDate: String, userName: String): Flow<DashboardBalances>

    fun getMovementsByName(startDate: String, endDate: String, user: String): Flow<DomainMovements>

    suspend fun addMovementToDb(movement: Movement)

    suspend fun editMovement(movement: Movement)

    suspend fun deleteMovement(movement: Movement)
}
