package com.daniel.budgetplanner.dashboard.presentation.movementdialog.route

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.daniel.base.utils.extension.CollectEffectWithLifecycle
import com.daniel.budgetplanner.dashboard.domain.model.Movement
import com.daniel.budgetplanner.dashboard.presentation.movementdialog.model.MovementOperation
import com.daniel.budgetplanner.dashboard.presentation.movementdialog.mvi.MovementDialog
import com.daniel.budgetplanner.dashboard.presentation.movementdialog.viewmodel.MovementDialogViewModel
import com.daniel.budgetplanner.dashboard.ui.movementdialog.screen.MovementDialogScreen
import com.daniel.budgetplanner.dashboard.utils.INCOME
import org.koin.androidx.compose.koinViewModel

@Composable
fun MovementDialogRoute(
    viewModel: MovementDialogViewModel = koinViewModel(),
    operation: String,
    isEditMovementDialog: Boolean = false,
    movement: Movement? = null,
    navigateBackToHome: () -> Unit
) {
    val viewState by viewModel.state.collectAsStateWithLifecycle()
    val movementOperation = when(operation){
        INCOME -> MovementOperation.INCOME_OPERATION
        else -> MovementOperation.EXPENSE_OPERATION
    }

    val stateSpecialCondition = (viewState as MovementDialog.State.Content).amountText.isEmpty()

    if (isEditMovementDialog && movement != null && stateSpecialCondition) {
        viewModel.onEditMovementInitDialogAction(
            movement = movement,
            movementOperation = movementOperation
        )
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
        onDescriptionChange = viewModel::onDescriptionChangeAction,
        onAmountChange = viewModel::onAmountChangeAction,
        onCategoryPickerClick = viewModel::onCategoryPickerClickAction,
        onCategorySelected = viewModel::onDialogCategorySelectedAction,
        onCategoryPickerDismiss = viewModel::onCategoryPickerDismissAction,
        onDateChangeIconClick = viewModel::onDateChangeIconClickAction,
        onDateSelected = viewModel::onDateSelectedAction,
        onDatePickerDismiss = viewModel::onDatePickerDismissAction,
        onCloseIconClick = viewModel::onCloseDialogIconClickAction,
        onContinueButtonClick = viewModel::onSaveButtonClickAction,
        onContinueButtonClickEditMode = viewModel::onSaveButtonEditModeAction
    )
}
