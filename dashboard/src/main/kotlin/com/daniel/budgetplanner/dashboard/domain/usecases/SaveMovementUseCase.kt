package com.daniel.budgetplanner.dashboard.domain.usecases

import com.daniel.base.domain.repository.StorageRepository
import com.daniel.base.domain.usecase.FlowUseCase
import com.daniel.budgetplanner.dashboard.data.utils.toMovement
import com.daniel.budgetplanner.dashboard.domain.repositories.MovementRepository
import com.daniel.budgetplanner.dashboard.presentation.movementdialog.model.MovementDialogData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class SaveMovementUseCase(
    val movementRepository: MovementRepository,
    val storageRepository: StorageRepository
) : FlowUseCase<MovementDialogData, Unit, Nothing >() {
    override suspend fun executeOnBackground(params: MovementDialogData): Flow<Unit> {
        val userName = storageRepository.getUser()
        movementRepository.addMovementToDb(params.toMovement(userName.toString()))

        return flowOf(Unit)
    }
}
