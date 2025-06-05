package com.daniel.budgetplanner.dashboard.domain.usecases

import com.daniel.base.domain.repository.StorageRepository
import com.daniel.base.domain.usecase.FlowUseCase
import com.daniel.budgetplanner.dashboard.data.utils.toPresentationMovements
import com.daniel.budgetplanner.dashboard.domain.repositories.MovementRepository
import com.daniel.budgetplanner.dashboard.domain.usecases.model.InitUseCaseResult
import com.daniel.budgetplanner.dashboard.utils.LOADING_DELAY
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map

class InitUseCase(
    val storageRepository: StorageRepository,
    val movementDbRepository: MovementRepository
) : FlowUseCase<Unit, InitUseCaseResult, Nothing>() {
    override suspend fun executeOnBackground(params: Unit): Flow<InitUseCaseResult> {

        val user = storageRepository.getUser()
        val startDate = storageRepository.getStartDate()
        val endDate = storageRepository.getEndData()
        val rangeOfDates = Pair(startDate.toString(), endDate.toString())
        val movementsFlow = movementDbRepository.getMovementsByName(
            startDate = startDate.toString(),
            endDate = endDate.toString(),
            user = user.toString()
        )
        val userMovements = movementsFlow.map { domainMovementsList ->
            domainMovementsList.toPresentationMovements()
        }.first()

        val balances = movementDbRepository.getActualBalance(
            startDate = startDate.toString(),
            endDate = endDate.toString(),
            userName = user.toString()
        ).first()

        return flowOf(
            InitUseCaseResult(
                userName = user.toString(),
                rangeOfDates = rangeOfDates ,
                userMovements = userMovements,
                actualBalances = balances
            )
        )
    }
}
