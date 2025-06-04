package com.daniel.budgetplanner.dashboard.presentation.home.action

import com.daniel.base.presentation.Mutation
import com.daniel.base.presentation.action.ActionProcessor
import com.daniel.budgetplanner.dashboard.presentation.home.mvi.Home
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class OnCategorySelectedActionProcessor :
    ActionProcessor<Home.State, Home.Action.FilterCategorySelection, Home.Effect>() {
    override fun process(
        action: Home.Action.FilterCategorySelection,
        sideEffect: (Home.Effect) -> Unit
    ): Flow<Mutation<Home.State>> {
        return flowOf { currentState ->
            currentState as Home.State.Content

            currentState.copy(
                categorySelected = action.category,
                isFilterShown = false
            )
        }
    }
}
