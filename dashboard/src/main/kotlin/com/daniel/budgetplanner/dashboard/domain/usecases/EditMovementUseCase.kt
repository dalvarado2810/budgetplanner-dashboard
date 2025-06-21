package com.daniel.budgetplanner.dashboard.domain.usecases

import com.daniel.base.domain.repository.StorageRepository
import com.daniel.base.domain.usecase.FlowUseCase
import com.daniel.budgetplanner.dashboard.data.utils.toMovement
import com.daniel.budgetplanner.dashboard.domain.repositories.MovementRepository
import com.daniel.budgetplanner.dashboard.presentation.movementdialog.model.MovementDialogEditModeData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class EditMovementUseCase(
    val movementRepository: MovementRepository,
    val storageRepository: StorageRepository
) : FlowUseCase<MovementDialogEditModeData, Unit, Nothing >() {
    override suspend fun executeOnBackground(params: MovementDialogEditModeData): Flow<Unit> {
        val userName = storageRepository.getUser()
        movementRepository.editMovement(params.toMovement(userName.toString()))

        return flowOf(Unit)
    }
}
