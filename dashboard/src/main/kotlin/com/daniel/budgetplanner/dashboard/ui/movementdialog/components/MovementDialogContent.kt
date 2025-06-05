package com.daniel.budgetplanner.dashboard.ui.movementdialog.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.remember
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.daniel.budgetplanner.dashboard.R
import com.daniel.budgetplanner.dashboard.presentation.movementdialog.model.MovementDialogData
import com.daniel.budgetplanner.dashboard.presentation.movementdialog.model.MovementOperation
import com.daniel.budgetplanner.dashboard.presentation.movementdialog.mvi.MovementDialog
import com.daniel.budgetplanner.dashboard.ui.home.components.ContinueButton
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
    onCloseIconClick: () -> Unit
) {
    val color = movementOperation.movementColor
    val descriptionText = remember { mutableStateOf(state.descriptionText) }
    val amountText = remember { mutableStateOf(state.amountText) }

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
            text = descriptionText.value,
            color = color,
            onDescriptionChange = onDescriptionChange,
            onCloseClick = onCloseIconClick
        )

        AmountRowComponent(
            amountText = amountText.value,
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
            enabled = state.isContinueButtonEnabled
        ) {
            val movement = MovementDialogData(
                movementDescription = descriptionText.value,
                movementAmount = state.amountText,
                dbMovementType = movementOperation.dbMovementType,
                movementCategory = state.categorySelected,
                date = state.dateSelected
            )
            onContinueButtonClick(movement)
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
            movementOperation = MovementOperation.INCOME_OPERATION,
            descriptionText = "Sueldo",
            amountText = "1200000",
            dateSelected = LocalDate.now(),
            categorySelected = "Ingreso Mensual",
            isContinueButtonEnabled = false,
            isDatePickerShown = false,
            isCategoryPickerShown = false
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
        onDescriptionChange = {}
    )
}
