package com.daniel.budgetplanner.dashboard.domain.usecases

import com.daniel.base.domain.repository.StorageRepository
import com.daniel.base.domain.usecase.FlowUseCase
import com.daniel.budgetplanner.dashboard.utils.EMPTY_STRING
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class EraseUserUseCase(
    val storageRepository: StorageRepository
) : FlowUseCase<Unit, Unit, Nothing>() {
    override suspend fun executeOnBackground(params: Unit): Flow<Unit> {
        storageRepository.setUser(EMPTY_STRING)
        return flowOf(Unit)
    }
}
