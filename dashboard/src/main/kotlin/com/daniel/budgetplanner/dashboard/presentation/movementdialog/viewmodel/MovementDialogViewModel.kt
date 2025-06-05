package com.daniel.budgetplanner.dashboard.presentation.movementdialog.viewmodel

import com.daniel.base.presentation.Mutation
import com.daniel.base.presentation.viewmodel.BaseViewModel
import com.daniel.budgetplanner.dashboard.presentation.movementdialog.action.OnCloseDialogIconClickActionProcessor
import com.daniel.budgetplanner.dashboard.presentation.movementdialog.model.MovementOperation
import com.daniel.budgetplanner.dashboard.presentation.movementdialog.mvi.MovementDialog
import com.daniel.budgetplanner.dashboard.utils.DEFAULT_CATEGORY
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

class MovementDialogViewModel(
    val onCloseDialogIconClickActionProcessor: OnCloseDialogIconClickActionProcessor
) : BaseViewModel<MovementDialog.State, MovementDialog.Action, MovementDialog.Effect>(
    initialState = MovementDialog.State.Content(
        movementOperation = MovementOperation.EXPENSE_OPERATION,
        descriptionText = "",
        amountText = "",
        dateSelected = LocalDate.now(),
        categorySelected = DEFAULT_CATEGORY,
        isContinueButtonEnabled = false,
        isDatePickerShown = false,
        isCategoryPickerShown = false
    )
) {
    fun onCloseDialogIconClick() {
        sendAction(MovementDialog.Action.CloseDialogIconClick)
    }

    override fun processAction(
        action: MovementDialog.Action, sideEffect: (MovementDialog.Effect) -> Unit
    ): Flow<Mutation<MovementDialog.State>> {
        return when(action) {
            is MovementDialog.Action.AmountChange -> TODO()
            is MovementDialog.Action.CategoryPickerClick -> TODO()
            is MovementDialog.Action.CategoryPickerDismiss -> TODO()
            is MovementDialog.Action.CategorySelected -> TODO()
            is MovementDialog.Action.CloseDialogIconClick -> {
              onCloseDialogIconClickActionProcessor.process(action, sideEffect)
            }
            is MovementDialog.Action.DateChangeIconClick -> TODO()
            is MovementDialog.Action.DatePickerDismiss -> TODO()
            is MovementDialog.Action.DateSelected -> TODO()
            is MovementDialog.Action.DescriptionChange -> TODO()
            is MovementDialog.Action.ContinueButtonClick -> TODO()
        }
    }
}
