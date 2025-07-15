package com.daniel.budgetplanner.dashboard.presentation.home.action

import com.daniel.base.presentation.Mutation
import com.daniel.base.presentation.action.ActionProcessor
import com.daniel.budgetplanner.dashboard.presentation.home.mvi.Home
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class OnClickMenuActionProcessor :
    ActionProcessor<Home.State, Home.Action.MenuButtonClick, Home.Effect>() {
    override fun process(
        action: Home.Action.MenuButtonClick,
        sideEffect: (Home.Effect) -> Unit
    ): Flow<Mutation<Home.State>> {
        return flowOf { currentState ->
            currentState as Home.State.Content
            
            currentState.copy(
                isMenuShown = true
            )
        }
    }
}
