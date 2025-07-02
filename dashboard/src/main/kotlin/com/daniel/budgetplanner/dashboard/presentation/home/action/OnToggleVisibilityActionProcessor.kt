package com.daniel.budgetplanner.dashboard.presentation.home.action

import com.daniel.base.presentation.Mutation
import com.daniel.base.presentation.action.ActionProcessor
import com.daniel.budgetplanner.dashboard.presentation.home.mvi.Home
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class OnToggleVisibilityActionProcessor :
    ActionProcessor<Home.State, Home.Action.ToggleVisibility, Home.Effect>() {
    override fun process(
        action: Home.Action.ToggleVisibility,
        sideEffect: (Home.Effect) -> Unit
    ): Flow<Mutation<Home.State>> {
        return flowOf { currentState ->
            currentState as Home.State.Content

            currentState.copy(
                isBalanceVisible = !currentState.isBalanceVisible
            )
        }
    }
}
