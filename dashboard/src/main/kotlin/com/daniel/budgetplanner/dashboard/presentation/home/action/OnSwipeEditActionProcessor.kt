package com.daniel.budgetplanner.dashboard.presentation.home.action

import com.daniel.base.presentation.Mutation
import com.daniel.base.presentation.action.ActionProcessor
import com.daniel.budgetplanner.dashboard.presentation.home.mvi.Home
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class OnSwipeEditActionProcessor :
    ActionProcessor<Home.State, Home.Action.OnSwipeEdit, Home.Effect>() {
    override fun process(
        action: Home.Action.OnSwipeEdit,
        sideEffect: (Home.Effect) -> Unit
    ): Flow<Mutation<Home.State>> {
        return flowOf { currentState ->
            sideEffect(Home.Effect.NavigateToEditMovementDialog(action.movement))
            currentState
        }
    }
}
