package com.daniel.budgetplanner.dashboard.domain.usecases

import com.daniel.base.domain.repository.StorageRepository
import com.daniel.base.domain.usecase.FlowUseCase
import com.daniel.budgetplanner.dashboard.domain.usecases.params.NewPeriodParams
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlin.apply

class NewPeriodSelectedUseCase(
    private val storageRepository: StorageRepository,
) : FlowUseCase<NewPeriodParams, Unit, Nothing>() {
    override suspend fun executeOnBackground(params: NewPeriodParams): Flow<Unit> {
        require(params.startDate != null && params.endDate != null)

        storageRepository.apply {
            setStartDate(params.startDate.toString())
            setEndDate(params.endDate.toString())
        }

        return flowOf(Unit)
    }
}
