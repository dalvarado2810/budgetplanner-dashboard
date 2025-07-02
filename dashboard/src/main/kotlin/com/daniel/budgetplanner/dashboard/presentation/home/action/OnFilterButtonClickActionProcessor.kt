package com.daniel.budgetplanner.dashboard.presentation.home.action

import com.daniel.base.presentation.Mutation
import com.daniel.base.presentation.action.ActionProcessor
import com.daniel.budgetplanner.dashboard.presentation.home.mvi.Home
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class OnFilterButtonClickActionProcessor :
    ActionProcessor<Home.State, Home.Action.FilterButtonClick, Home.Effect>() {
    override fun process(
        action: Home.Action.FilterButtonClick,
        sideEffect: (Home.Effect) -> Unit
    ): Flow<Mutation<Home.State>> {
        return flowOf { currentState ->
            currentState as Home.State.Content

            currentState.copy(
                isFilterShown = true
            )
        }
    }
}
