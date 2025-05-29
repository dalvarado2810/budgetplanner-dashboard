package com.daniel.budgetplanner.dashboard.presentation.home.viewmodel

import com.daniel.base.presentation.Mutation
import com.daniel.base.presentation.viewmodel.BaseViewModel
import com.daniel.budgetplanner.dashboard.presentation.home.action.InitActionProcessor
import com.daniel.budgetplanner.dashboard.presentation.home.action.OnToggleVisibilityActionProcessor
import com.daniel.budgetplanner.dashboard.presentation.home.mvi.Home
import kotlinx.coroutines.flow.Flow

class HomeViewModel(
    val initActionProcessor: InitActionProcessor,
    val onToggleVisibilityActionProcessor: OnToggleVisibilityActionProcessor
) : BaseViewModel<Home.State, Home.Action, Home.Effect>(
    initialState = Home.State.Loading,
    initialAction = Home.Action.Init
) {
    fun onToggleVisibilityAction() {
        sendAction(Home.Action.ToggleVisibility)
    }

    override fun processAction(
        action: Home.Action,
        sideEffect: (Home.Effect) -> Unit
    ): Flow<Mutation<Home.State>> {
        return when(action) {
            is Home.Action.CancelEraseUser -> TODO()
            is Home.Action.ConfirmEraseUser -> TODO()
            is Home.Action.DismissIncomeDialog -> TODO()
            is Home.Action.EraseUserMenuSelection -> TODO()
            is Home.Action.FilterButtonClick -> TODO()
            is Home.Action.FilterCategorySelection -> TODO()
            is Home.Action.HideBalancesButtonClick -> TODO()
            is Home.Action.IncomeButtonClick -> TODO()
            is Home.Action.Init -> {
                initActionProcessor.process(action, sideEffect)
            }
            is Home.Action.MenuButtonClick -> TODO()
            is Home.Action.NewPeriodMenuSelection -> TODO()
            is Home.Action.OnSwipeDelete -> TODO()
            is Home.Action.PolicyMenuSelection -> TODO()
            is Home.Action.ToggleVisibility -> {
                onToggleVisibilityActionProcessor.process(action, sideEffect)
            }
        }
    }
}
