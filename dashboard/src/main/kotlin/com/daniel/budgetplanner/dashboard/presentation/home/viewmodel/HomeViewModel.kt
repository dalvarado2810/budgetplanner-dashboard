package com.daniel.budgetplanner.dashboard.presentation.home.viewmodel

import com.daniel.base.presentation.Mutation
import com.daniel.base.presentation.viewmodel.BaseViewModel
import com.daniel.budgetplanner.dashboard.presentation.home.action.OnCancelEraseUserActionProcessor
import com.daniel.budgetplanner.dashboard.presentation.home.action.OnInitActionProcessor
import com.daniel.budgetplanner.dashboard.presentation.home.action.OnMenuDismissActionProcessor
import com.daniel.budgetplanner.dashboard.presentation.home.action.OnClickMenuActionProcessor
import com.daniel.budgetplanner.dashboard.presentation.home.action.OnConfirmEraseUserActionProcessor
import com.daniel.budgetplanner.dashboard.presentation.home.action.OnDatePickerDismissActionProcessor
import com.daniel.budgetplanner.dashboard.presentation.home.action.OnEraseUserMenuSelectionActionProcessor
import com.daniel.budgetplanner.dashboard.presentation.home.action.OnNewPeriodMenuSelectionActionProcessor
import com.daniel.budgetplanner.dashboard.presentation.home.action.OnPolicyClickActionProcessor
import com.daniel.budgetplanner.dashboard.presentation.home.action.OnPolicyDialogDismissActionProcessor
import com.daniel.budgetplanner.dashboard.presentation.home.action.OnToggleVisibilityActionProcessor
import com.daniel.budgetplanner.dashboard.presentation.home.mvi.Home
import kotlinx.coroutines.flow.Flow

class HomeViewModel(
    val onInitActionProcessor: OnInitActionProcessor,
    val onToggleVisibilityActionProcessor: OnToggleVisibilityActionProcessor,
    val onClickMenuActionProcessor: OnClickMenuActionProcessor,
    val onMenuDismissActionProcessor: OnMenuDismissActionProcessor,
    val onPolicyClickActionProcessor: OnPolicyClickActionProcessor,
    val onPolicyDialogDismissActionProcessor: OnPolicyDialogDismissActionProcessor,
    val onNewPeriodMenuSelectionActionProcessor: OnNewPeriodMenuSelectionActionProcessor,
    val onDatePickerDismissActionProcessor: OnDatePickerDismissActionProcessor,
    val onEraseUserMenuSelectionActionProcessor: OnEraseUserMenuSelectionActionProcessor,
    val onConfirmEraseUserActionProcessor: OnConfirmEraseUserActionProcessor,
    val onCancelEraseUserActionProcessor: OnCancelEraseUserActionProcessor
) : BaseViewModel<Home.State, Home.Action, Home.Effect>(
    initialState = Home.State.Loading,
    initialAction = Home.Action.Init
) {
    fun onToggleVisibilityAction() {
        sendAction(Home.Action.ToggleVisibility)
    }

    fun onMenuClickAction() {
        sendAction(Home.Action.MenuButtonClick)
    }

    fun onMenuDismissAction() {
        sendAction(Home.Action.MenuDismissClick)
    }

    fun onDatePickerClickAction() {
        sendAction(Home.Action.NewPeriodMenuSelection)
    }

    fun onDatePickerDismissAction() {
        sendAction(Home.Action.DatePickerDismiss)
    }

    fun onPolicyButtonClickAction() {
        sendAction(Home.Action.PolicyMenuSelection)
    }

    fun onPolicyDialogDismissAction() {
        sendAction(Home.Action.PolicyDialogDismiss)
    }

    fun onEraseUserClickAction() {
        sendAction(Home.Action.EraseUserMenuSelection)
    }

    fun onConfirmEraseUserAction() {
        sendAction(Home.Action.ConfirmEraseUser)
    }

    fun onCancelEraseUserAction() {
        sendAction(Home.Action.CancelEraseUser)
    }

    fun onIncomeButtonClickAction() {
        sendAction(Home.Action.IncomeButtonClick)
    }

    fun onExpenseButtonClickAction() {
        sendAction(Home.Action.ExpenseButtonClick)
    }

    override fun processAction(
        action: Home.Action,
        sideEffect: (Home.Effect) -> Unit
    ): Flow<Mutation<Home.State>> {
        return when(action) {
            is Home.Action.CancelEraseUser -> {
                onCancelEraseUserActionProcessor.process(action, sideEffect)
            }
            is Home.Action.ConfirmEraseUser -> {
                //miss real usecase
                onConfirmEraseUserActionProcessor.process(action, sideEffect)
            }
            is Home.Action.EraseUserMenuSelection -> {
                onEraseUserMenuSelectionActionProcessor.process(action, sideEffect)
            }
            is Home.Action.FilterButtonClick -> TODO()
            is Home.Action.FilterCategorySelection -> TODO()
            is Home.Action.Init -> {
                onInitActionProcessor.process(action, sideEffect)
            }
            is Home.Action.MenuButtonClick -> {
                onClickMenuActionProcessor.process(action, sideEffect)
            }
            is Home.Action.MenuDismissClick -> {
                onMenuDismissActionProcessor.process(action, sideEffect)
            }
            is Home.Action.NewPeriodMenuSelection -> {
                onNewPeriodMenuSelectionActionProcessor.process(action, sideEffect)
            }
            is Home.Action.OnSwipeDelete -> TODO()
            is Home.Action.PolicyMenuSelection -> {
                onPolicyClickActionProcessor.process(action, sideEffect)
            }
            is Home.Action.ToggleVisibility -> {
                onToggleVisibilityActionProcessor.process(action, sideEffect)
            }
            is Home.Action.DatePickerDismiss -> {
                onDatePickerDismissActionProcessor.process(action, sideEffect)
            }
            is Home.Action.PolicyDialogDismiss -> {
                onPolicyDialogDismissActionProcessor.process(action, sideEffect)
            }
            is Home.Action.ExpenseButtonClick -> TODO()
            is Home.Action.IncomeButtonClick -> TODO()
        }
    }
}
