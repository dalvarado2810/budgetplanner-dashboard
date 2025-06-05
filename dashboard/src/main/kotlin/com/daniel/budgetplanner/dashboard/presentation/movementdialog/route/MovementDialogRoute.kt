package com.daniel.budgetplanner.dashboard.presentation.movementdialog.route

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.daniel.base.utils.extension.CollectEffectWithLifecycle
import com.daniel.budgetplanner.dashboard.presentation.movementdialog.model.MovementOperation
import com.daniel.budgetplanner.dashboard.presentation.movementdialog.mvi.MovementDialog
import com.daniel.budgetplanner.dashboard.presentation.movementdialog.viewmodel.MovementDialogViewModel
import com.daniel.budgetplanner.dashboard.ui.movementdialog.screen.MovementDialogScreen
import com.daniel.budgetplanner.dashboard.utils.INCOME
import org.koin.androidx.compose.koinViewModel

@Composable
fun MovementDialogRoute(
    viewModel: MovementDialogViewModel = koinViewModel(),
    movementOperation: String,
    navigateBackToHome: () -> Unit
) {
    val viewState by viewModel.state.collectAsStateWithLifecycle()
    val movementOperation = when(movementOperation){
        INCOME -> MovementOperation.INCOME_OPERATION
        else -> MovementOperation.EXPENSE_OPERATION
    }

    CollectEffectWithLifecycle(flow = viewModel.effect) { effect ->
        when (effect) {
            MovementDialog.Effect.NavigateBackToHome -> {
                navigateBackToHome()
            }
        }
    }

    MovementDialogScreen(
        state = viewState,
        movementOperation = movementOperation,
        onDescriptionChange = {},
        onAmountChange = {},
        onCategoryPickerClick = {},
        onCategorySelected = {},
        onCategoryPickerDismiss = {},
        onDateChangeIconClick = {},
        onDateSelected = {},
        onDatePickerDismiss = {},
        onCloseIconClick = viewModel::onCloseDialogIconClick,
        onContinueButtonClick = {}
    )
}
