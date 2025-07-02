package com.daniel.budgetplanner.dashboard.presentation.home.action

import com.daniel.base.presentation.Mutation
import com.daniel.base.presentation.action.ActionProcessor
import com.daniel.budgetplanner.dashboard.presentation.home.mvi.Home
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class OnEraseUserMenuSelectionActionProcessor :
    ActionProcessor<Home.State, Home.Action.EraseUserMenuSelection, Home.Effect>() {
    override fun process(
        action: Home.Action.EraseUserMenuSelection,
        sideEffect: (Home.Effect) -> Unit
    ): Flow<Mutation<Home.State>> {
        return flowOf { currentState ->
            currentState as Home.State.Content

            currentState.copy(
                isChangeUserDialogShown = true,
                isMenuShown = false
            )
        }
    }
}
