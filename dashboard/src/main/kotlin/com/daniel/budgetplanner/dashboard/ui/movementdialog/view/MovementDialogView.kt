package com.daniel.budgetplanner.dashboard.ui.movementdialog.view

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetValue
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.daniel.base.ui.theme.CardColor
import com.daniel.budgetplanner.dashboard.R
import com.daniel.budgetplanner.dashboard.presentation.movementdialog.model.MovementDialogData
import com.daniel.budgetplanner.dashboard.presentation.movementdialog.model.MovementDialogEditModeData
import com.daniel.budgetplanner.dashboard.presentation.movementdialog.model.MovementOperation
import com.daniel.budgetplanner.dashboard.presentation.movementdialog.mvi.MovementDialog
import com.daniel.budgetplanner.dashboard.ui.movementdialog.components.MovementDialogContent
import java.time.LocalDate

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovementDialogView(
    state: MovementDialog.State.Content,
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
    onContinueButtonClickEditMode: (movement: MovementDialogEditModeData) -> Unit,
    onCloseIconClick: () -> Unit
) {
    val bottomSheetState = rememberModalBottomSheetState(
        confirmValueChange = {
            it != SheetValue.Hidden
        }
    )

    ModalBottomSheet(
        sheetState = bottomSheetState,
        dragHandle = null,
        content = {
            MovementDialogContent(
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
                onContinueButtonClick = onContinueButtonClick,
                onContinueButtonClickEditMode = onContinueButtonClickEditMode
            )
        },
        containerColor = CardColor,
        shape = RoundedCornerShape(
            topStart = dimensionResource(R.dimen.dimen_48dp),
            topEnd = dimensionResource(R.dimen.dimen_48dp)),
        onDismissRequest = {}
    )
}

@Preview(name = "MovementDialogComponent")
@Composable
fun PreviewMovementDialogComponent() {
    MovementDialogView(
        state = MovementDialog.State.Content(
            descriptionText = "ingreso",
            amountText = "",
            dateSelected = LocalDate.now(),
            categorySelected = "Ingreso Mensual",
            isContinueButtonEnabled = false,
            isDatePickerShown = false,
            isCategoryPickerShown = false,
            movementOperation = MovementOperation.INCOME_OPERATION
        ),
        movementOperation = MovementOperation.EXPENSE_OPERATION,
        onAmountChange = {},
        onDescriptionChange = {},
        onCategoryPickerClick = {},
        onCategorySelected = {},
        onCategoryPickerDismiss = {},
        onDateChangeIconClick = {},
        onDateSelected = {},
        onDatePickerDismiss = {},
        onContinueButtonClick = {},
        onCloseIconClick = {},
        onContinueButtonClickEditMode = {}
    )
}
