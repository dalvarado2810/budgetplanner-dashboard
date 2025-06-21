package com.daniel.budgetplanner.dashboard.ui.movementdialog.components

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.daniel.budgetplanner.dashboard.R
import com.daniel.budgetplanner.dashboard.presentation.movementdialog.model.MovementDialogData
import com.daniel.budgetplanner.dashboard.presentation.movementdialog.model.MovementDialogEditModeData
import com.daniel.budgetplanner.dashboard.presentation.movementdialog.model.MovementOperation
import com.daniel.budgetplanner.dashboard.presentation.movementdialog.mvi.MovementDialog
import com.daniel.budgetplanner.dashboard.ui.home.components.ContinueButton
import com.daniel.budgetplanner.dashboard.utils.DEFAULT_CATEGORY
import com.daniel.budgetplanner.dashboard.utils.toMovementDialogData
import com.daniel.budgetplanner.dashboard.utils.toMovementDialogEditModeData
import java.time.LocalDate

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun MovementDialogContent(
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
    val color = movementOperation.movementColor
    Log.e("state","description = ${state.descriptionText}")
    Log.e("state","amount = ${state.amountText}")
    Log.e("state","date = ${state.dateSelected}")
    Log.e("state","category = ${state.categorySelected}")

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.dimen_2dp)),
        modifier = Modifier
            .padding(bottom = dimensionResource(R.dimen.dimen_24dp))
    ) {
        TopDialogTitleComponent(
            title = movementOperation.title,
            color = color
        )

        DescriptionRowComponent(
            text = state.descriptionText,
            color = color,
            onDescriptionChange = onDescriptionChange,
            onCloseClick = onCloseIconClick
        )

        AmountRowComponent(
            text = state.amountText,
            color = color,
            onAmountChange = onAmountChange
        )

        DatePickerRowComponent(
            dateSelected = state.dateSelected,
            color = color,
            onDateChangeIconClick = onDateChangeIconClick
        )

        CategorySelectionRowComponent(
            color = color,
            categorySelected = state.categorySelected,
            categoryList = movementOperation.categoryList,
            isCategoryPickerShown = state.isCategoryPickerShown,
            onCategoryPickerClick = onCategoryPickerClick,
            onCategoryPickerDismiss = onCategoryPickerDismiss,
            onCategorySelected = onCategorySelected
        )

        ContinueButton(
            text = stringResource(id = R.string.save_movement),
            color = color,
            enabled = state.amountText.isNotEmpty() &&
                    state.descriptionText.isNotEmpty() &&
                    state.categorySelected != DEFAULT_CATEGORY
        ) {
            val isEditMode = state.movementToEdit != null
            if (!isEditMode) {
                val movement = state.toMovementDialogData(movementOperation)
                onContinueButtonClick(movement)
            } else {
                val movementToEdit = state.toMovementDialogEditModeData(movementOperation)
                onContinueButtonClickEditMode(movementToEdit)
            }
        }

        if(state.isDatePickerShown) {
            MyDatePickerDialogComponent(
                onDateSelected = onDateSelected,
                onDismiss = onDatePickerDismiss
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MovementDialogContentPreview() {
    MovementDialogContent(
        state = MovementDialog.State.Content(
            descriptionText = "Sueldo",
            amountText = "1200000",
            dateSelected = LocalDate.now(),
            categorySelected = "Ingreso Mensual",
            isContinueButtonEnabled = false,
            isDatePickerShown = false,
            isCategoryPickerShown = false,
            movementOperation = MovementOperation.INCOME_OPERATION
        ),
        movementOperation = MovementOperation.INCOME_OPERATION,
        onCategorySelected = {},
        onDateChangeIconClick = {},
        onDateSelected = {},
        onDatePickerDismiss = {},
        onCategoryPickerClick = {},
        onCategoryPickerDismiss = {},
        onContinueButtonClick = {},
        onCloseIconClick = {},
        onAmountChange = {},
        onDescriptionChange = {},
        onContinueButtonClickEditMode = {}
    )
}
