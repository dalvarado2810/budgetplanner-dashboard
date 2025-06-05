package com.daniel.budgetplanner.dashboard.ui.movementdialog.screen

import androidx.compose.runtime.Composable
import com.daniel.budgetplanner.dashboard.presentation.movementdialog.model.MovementDialogData
import com.daniel.budgetplanner.dashboard.presentation.movementdialog.model.MovementOperation
import com.daniel.budgetplanner.dashboard.presentation.movementdialog.mvi.MovementDialog
import com.daniel.budgetplanner.dashboard.ui.movementdialog.view.MovementDialogView
import java.time.LocalDate

@Composable
fun MovementDialogScreen(
    state: MovementDialog.State,
    movementOperation: MovementOperation,
    onDescriptionChange: (String) -> Unit,
    onAmountChange: (String) -> Unit,
    onDateChangeIconClick: () -> Unit,
    onDateSelected: (LocalDate?) -> Unit,
    onDatePickerDismiss: () -> Unit,
    onCategoryPickerClick: (Boolean) -> Unit,
    onCategorySelected: (String) -> Unit,
    onCategoryPickerDismiss: () -> Unit,
    onContinueButtonClick: (movement: MovementDialogData) ->  Unit,
    onCloseIconClick: () -> Unit
) {
    require(state is MovementDialog.State.Content)

    MovementDialogView(
        state = state,
        movementOperation = movementOperation,
        onAmountChange = onAmountChange,
        onDescriptionChange = onDescriptionChange,
        onCategorySelected = onCategorySelected,
        onCategoryPickerClick = onCategoryPickerClick,
        onCategoryPickerDismiss = onCategoryPickerDismiss,
        onDateChangeIconClick = onDateChangeIconClick,
        onDateSelected = onDateSelected,
        onDatePickerDismiss = onDatePickerDismiss,
        onCloseIconClick = onCloseIconClick,
        onContinueButtonClick = onContinueButtonClick
    )
}
