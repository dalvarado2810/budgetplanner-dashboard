package com.daniel.budgetplanner.dashboard.domain.usecases

import com.daniel.base.domain.usecase.FlowUseCase
import com.daniel.budgetplanner.dashboard.domain.repositories.MovementRepository
import com.daniel.budgetplanner.dashboard.domain.usecases.model.DeleteMovementUseCaseResult
import com.daniel.budgetplanner.dashboard.domain.usecases.params.DbOperationsParams
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf

class DeleteMovementUseCase(
    val movementRepository: MovementRepository
) : FlowUseCase<DbOperationsParams, DeleteMovementUseCaseResult, Nothing>() {
    override suspend fun executeOnBackground(params: DbOperationsParams): Flow<DeleteMovementUseCaseResult> {
        movementRepository.deleteMovement(params.movement)

        val userMovements = movementRepository.getMovementsByName(
            startDate = params.rangeDates.first,
            endDate = params.rangeDates.second,
            user = params.userName
        ).first()

        val balances = movementRepository.getActualBalance(
            startDate = params.rangeDates.first,
            endDate = params.rangeDates.second,
            userName = params.userName
        ).first()

        return flowOf(
            DeleteMovementUseCaseResult(
                actualBalances = balances,
                userMovements = userMovements
            )
        )
    }
}
