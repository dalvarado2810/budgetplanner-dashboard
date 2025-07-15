package com.daniel.budgetplanner.dashboard.presentation.movementdialog.viewmodel

import com.daniel.base.presentation.Mutation
import com.daniel.base.presentation.viewmodel.BaseViewModel
import com.daniel.budgetplanner.dashboard.domain.model.Movement
import com.daniel.budgetplanner.dashboard.presentation.movementdialog.action.OnAmountChangeActionProcessor
import com.daniel.budgetplanner.dashboard.presentation.movementdialog.action.OnCategoryPickerClickActionProcessor
import com.daniel.budgetplanner.dashboard.presentation.movementdialog.action.OnCategoryPickerDismissActionProcessor
import com.daniel.budgetplanner.dashboard.presentation.movementdialog.action.OnCloseDialogIconClickActionProcessor
import com.daniel.budgetplanner.dashboard.presentation.movementdialog.action.OnDateChangeIconClickActionProcessor
import com.daniel.budgetplanner.dashboard.presentation.movementdialog.action.OnDateSelectedActionProcessor
import com.daniel.budgetplanner.dashboard.presentation.movementdialog.action.OnDescriptionChangeActionProcessor
import com.daniel.budgetplanner.dashboard.presentation.movementdialog.action.OnDialogCategorySelectedActionProcessor
import com.daniel.budgetplanner.dashboard.presentation.movementdialog.action.OnDialogDatePickerDismissActionProcessor
import com.daniel.budgetplanner.dashboard.presentation.movementdialog.action.OnEditMovementInitDialogActionProcessor
import com.daniel.budgetplanner.dashboard.presentation.movementdialog.action.OnSaveButtonClickActionProcessor
import com.daniel.budgetplanner.dashboard.presentation.movementdialog.action.OnSaveButtonClickEditModeActionProcessor
import com.daniel.budgetplanner.dashboard.presentation.movementdialog.model.MovementDialogData
import com.daniel.budgetplanner.dashboard.presentation.movementdialog.model.MovementDialogEditModeData
import com.daniel.budgetplanner.dashboard.presentation.movementdialog.model.MovementOperation
import com.daniel.budgetplanner.dashboard.presentation.movementdialog.mvi.MovementDialog
import com.daniel.budgetplanner.dashboard.utils.DEFAULT_CATEGORY
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

class MovementDialogViewModel(
    val onCloseDialogIconClickActionProcessor: OnCloseDialogIconClickActionProcessor,
    val onDescriptionChangeActionProcessor: OnDescriptionChangeActionProcessor,
    val onAmountChangeActionProcessor: OnAmountChangeActionProcessor,
    val onDateChangeIconClickActionProcessor: OnDateChangeIconClickActionProcessor,
    val onDialogDatePickerDismissActionProcessor: OnDialogDatePickerDismissActionProcessor,
    val onDateSelectedActionProcessor: OnDateSelectedActionProcessor,
    val onCategoryPickerClickActionProcessor: OnCategoryPickerClickActionProcessor,
    val onDialogCategorySelectedActionProcessor: OnDialogCategorySelectedActionProcessor,
    val onCategoryPickerDismissActionProcessor: OnCategoryPickerDismissActionProcessor,
    val onSaveButtonClickActionProcessor: OnSaveButtonClickActionProcessor,
    val onEditMovementInitDialogActionProcessor: OnEditMovementInitDialogActionProcessor,
    val onSaveButtonClickEditModeActionProcessor: OnSaveButtonClickEditModeActionProcessor
) : BaseViewModel<MovementDialog.State, MovementDialog.Action, MovementDialog.Effect>(
    initialState = MovementDialog.State.Content(
        descriptionText = "",
        amountText = "",
        dateSelected = LocalDate.now(),
        categorySelected = DEFAULT_CATEGORY,
        isContinueButtonEnabled = false,
        isDatePickerShown = false,
        isCategoryPickerShown = false,
        movementOperation = MovementOperation.INCOME_OPERATION
    )
) {
    fun onCloseDialogIconClickAction() {
        sendAction(MovementDialog.Action.CloseDialogIconClick)
    }

    fun onDescriptionChangeAction(descriptionText: String) {
        sendAction(MovementDialog.Action.DescriptionChange(descriptionText))
    }

    fun onAmountChangeAction(amountValue: String) {
        sendAction(MovementDialog.Action.AmountChange(amountValue))
    }

    fun onDateChangeIconClickAction() {
        sendAction(MovementDialog.Action.DateChangeIconClick)
    }

    fun onDatePickerDismissAction() {
        sendAction(MovementDialog.Action.DatePickerDismiss)
    }

    fun onDateSelectedAction(date: LocalDate?) {
        date?.let {
            sendAction(MovementDialog.Action.DateSelected(it))
        }
    }

    fun onCategoryPickerClickAction(isPick: Boolean) {
        sendAction(MovementDialog.Action.CategoryPickerClick(isPick))
    }

    fun onDialogCategorySelectedAction(category: String) {
        sendAction(MovementDialog.Action.CategorySelected(category))
    }

    fun onCategoryPickerDismissAction() {
        sendAction(MovementDialog.Action.CategoryPickerDismiss)
    }

    fun onSaveButtonClickAction(movement: MovementDialogData) {
        sendAction(MovementDialog.Action.SaveButtonClick(movement))
    }

    fun onEditMovementInitDialogAction(movement: Movement, movementOperation: MovementOperation) {
        sendAction(
            MovementDialog.Action.EditDialogInit(
                movement = movement,
                movementOperation = movementOperation
            )
        )
    }

    fun onSaveButtonEditModeAction(movementToEdit: MovementDialogEditModeData) {
        sendAction(MovementDialog.Action.SaveButtonEditModeClick(movementToEdit))
    }

    override fun processAction(
        action: MovementDialog.Action, sideEffect: (MovementDialog.Effect) -> Unit
    ): Flow<Mutation<MovementDialog.State>> {
        return when(action) {
            is MovementDialog.Action.AmountChange -> {
                onAmountChangeActionProcessor.process(action, sideEffect)
            }
            is MovementDialog.Action.CategoryPickerClick -> {
                onCategoryPickerClickActionProcessor.process(action, sideEffect)
            }
            is MovementDialog.Action.CategoryPickerDismiss -> {
                onCategoryPickerDismissActionProcessor.process(action, sideEffect)
            }
            is MovementDialog.Action.CategorySelected -> {
                onDialogCategorySelectedActionProcessor.process(action, sideEffect)
            }
            is MovementDialog.Action.CloseDialogIconClick -> {
                onCloseDialogIconClickActionProcessor.process(action, sideEffect)
            }
            is MovementDialog.Action.DateChangeIconClick -> {
                onDateChangeIconClickActionProcessor.process(action, sideEffect)
            }
            is MovementDialog.Action.DatePickerDismiss -> {
                onDialogDatePickerDismissActionProcessor.process(action, sideEffect)
            }
            is MovementDialog.Action.DateSelected -> {
                onDateSelectedActionProcessor.process(action, sideEffect)
            }
            is MovementDialog.Action.DescriptionChange -> {
                onDescriptionChangeActionProcessor.process(action, sideEffect)
            }
            is MovementDialog.Action.SaveButtonClick -> {
                onSaveButtonClickActionProcessor.process(action, sideEffect)
            }

            is MovementDialog.Action.EditDialogInit -> {
                onEditMovementInitDialogActionProcessor.process(action, sideEffect)
            }

            is MovementDialog.Action.SaveButtonEditModeClick -> {
                onSaveButtonClickEditModeActionProcessor.process(action, sideEffect)
            }
        }
    }
}
