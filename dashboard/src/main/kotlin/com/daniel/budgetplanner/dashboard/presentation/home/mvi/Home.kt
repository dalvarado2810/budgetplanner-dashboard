package com.daniel.budgetplanner.dashboard.presentation.home.mvi

import com.daniel.base.presentation.ViewAction
import com.daniel.base.presentation.ViewEffect
import com.daniel.base.presentation.ViewState
import com.daniel.budgetplanner.dashboard.domain.model.DashboardBalances
import com.daniel.budgetplanner.dashboard.domain.model.PresentationMovements
import com.daniel.budgetplanner.dashboard.utils.ALL_CATEGORIES

object Home {
    sealed class State : ViewState() {
        data object Loading : State()

        data object Error : State()

        data class Content(
            val name: String,
            val actualBalances: DashboardBalances,
            val movements: PresentationMovements,
            val rangeDates: Pair<String, String>,
            val categorySelected: String = ALL_CATEGORIES,
            val isFilterShown: Boolean = false,
            val isMenuShown: Boolean = false,
            val isPolicyDialogShown: Boolean = false,
            val isDatePickerShown: Boolean = false,
            val isChangeUserDialogShown: Boolean = false,
            val isBalanceVisible: Boolean = true
        ) : State()
    }

    sealed class Action : ViewAction() {
        data object Init : Action()

        data object ToggleVisibility: Action()

        data object IncomeButtonClick : Action()

        data object DismissIncomeDialog : Action()

        data object MenuButtonClick : Action()

        data object MenuDismissClick : Action()

        data object EraseUserMenuSelection : Action()

        data object NewPeriodMenuSelection : Action()

        data object DatePickerDismiss : Action()

        data object PolicyMenuSelection : Action()

        data object PolicyDialogDismiss : Action()

        data object FilterButtonClick : Action()

        data class FilterCategorySelection(val category: String) : Action()

        data class OnSwipeDelete(val position: Int) : Action()

        data object ConfirmEraseUser : Action()

        data object CancelEraseUser : Action()
    }

    sealed class Effect : ViewEffect() {
        data object NavigateToIncomeDialog : Effect()

        data object NavigateToExpenseDialog : Effect()

        data object NavigateToDatePicker : Effect()

        data object NavigateToPolicyDialog : Effect()
    }
}
