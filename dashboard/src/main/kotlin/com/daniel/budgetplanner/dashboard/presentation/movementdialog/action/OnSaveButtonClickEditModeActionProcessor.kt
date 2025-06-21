package com.daniel.budgetplanner.dashboard.presentation.movementdialog.action

import com.daniel.base.domain.usecase.UseCaseState
import com.daniel.base.presentation.Mutation
import com.daniel.base.presentation.action.ActionProcessor
import com.daniel.budgetplanner.dashboard.domain.usecases.EditMovementUseCase
import com.daniel.budgetplanner.dashboard.presentation.movementdialog.mvi.MovementDialog
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class OnSaveButtonClickEditModeActionProcessor(
    val saveMovementUseCase: EditMovementUseCase
) : ActionProcessor<MovementDialog.State,
            MovementDialog.Action.SaveButtonEditModeClick,
            MovementDialog.Effect>() {
    override fun process(
        action: MovementDialog.Action.SaveButtonEditModeClick,
        sideEffect: (MovementDialog.Effect) -> Unit
    ): Flow<Mutation<MovementDialog.State>> {
        return saveMovementUseCase.execute(
            params = action.movement
        ).map { useCaseState ->
            when(useCaseState) {
                is UseCaseState.Data -> { currentState ->
                    sideEffect(MovementDialog.Effect.NavigateBackToHome)
                    currentState
                }
                is UseCaseState.Error -> { currentState ->
                    currentState
                }
                is UseCaseState.Loading -> { currentState ->
                    currentState
                }
            }
        }
    }
}
