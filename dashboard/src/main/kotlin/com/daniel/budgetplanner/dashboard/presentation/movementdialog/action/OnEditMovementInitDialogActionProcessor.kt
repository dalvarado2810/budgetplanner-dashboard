package com.daniel.budgetplanner.dashboard.presentation.movementdialog.action

import com.daniel.base.presentation.Mutation
import com.daniel.base.presentation.action.ActionProcessor
import com.daniel.budgetplanner.dashboard.presentation.movementdialog.mvi.MovementDialog
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class OnEditMovementInitDialogActionProcessor
    : ActionProcessor<MovementDialog.State,
        MovementDialog.Action.EditDialogInit,
        MovementDialog.Effect>() {
    override fun process(
        action: MovementDialog.Action.EditDialogInit,
        sideEffect: (MovementDialog.Effect) -> Unit
    ): Flow<Mutation<MovementDialog.State>> {
        return flowOf { _ ->
            MovementDialog.State.Content(
                descriptionText = action.movement.movementDescription,
                amountText = action.movement.movementAmount.toString(),
                dateSelected = action.movement.date,
                categorySelected = action.movement.movementCategory.value,
                movementToEdit = action.movement,
                isContinueButtonEnabled = true,
                isDatePickerShown = false,
                isCategoryPickerShown = false,
                movementOperation = action.movementOperation
            )
        }
    }
}
