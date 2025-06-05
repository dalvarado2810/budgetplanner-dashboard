package com.daniel.budgetplanner.dashboard.presentation.movementdialog.action

import com.daniel.base.presentation.Mutation
import com.daniel.base.presentation.action.ActionProcessor
import com.daniel.budgetplanner.dashboard.presentation.movementdialog.mvi.MovementDialog
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class OnCloseDialogIconClickActionProcessor :
    ActionProcessor<MovementDialog.State,
            MovementDialog.Action.CloseDialogIconClick,
            MovementDialog.Effect>() {
    override fun process(
        action: MovementDialog.Action.CloseDialogIconClick,
        sideEffect: (MovementDialog.Effect) -> Unit
    ): Flow<Mutation<MovementDialog.State>> {
        return flowOf { currentState ->
            sideEffect(MovementDialog.Effect.NavigateBackToHome)

            currentState
        }
    }
}
