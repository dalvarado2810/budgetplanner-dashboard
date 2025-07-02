package com.daniel.budgetplanner.dashboard.presentation.movementdialog.action

import com.daniel.base.presentation.Mutation
import com.daniel.base.presentation.action.ActionProcessor
import com.daniel.budgetplanner.dashboard.presentation.movementdialog.mvi.MovementDialog
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class OnDialogCategorySelectedActionProcessor : ActionProcessor<MovementDialog.State,
        MovementDialog.Action.CategorySelected,
        MovementDialog.Effect>() {
    override fun process(
        action: MovementDialog.Action.CategorySelected,
        sideEffect: (MovementDialog.Effect) -> Unit
    ): Flow<Mutation<MovementDialog.State>> {
        return flowOf { currentState ->
            currentState as MovementDialog.State.Content

            currentState.copy(
                categorySelected = action.category,
                isCategoryPickerShown = false
            )
        }
    }
}
