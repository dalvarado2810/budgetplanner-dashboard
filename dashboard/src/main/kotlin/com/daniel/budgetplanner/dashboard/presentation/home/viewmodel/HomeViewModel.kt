package com.daniel.budgetplanner.dashboard.presentation.home.viewmodel

import com.daniel.base.presentation.Mutation
import com.daniel.base.presentation.viewmodel.BaseViewModel
import com.daniel.budgetplanner.dashboard.presentation.home.mvi.Home
import kotlinx.coroutines.flow.Flow

class HomeViewModel : BaseViewModel<Home.State, Home.Action, Home.Effect>(
    initialState = Home.State.Loading,
    initialAction = Home.Action.Init
) {
    override fun processAction(
        action: Home.Action,
        sideEffect: (Home.Effect) -> Unit
    ): Flow<Mutation<Home.State>> {
        TODO("Not yet implemented")
    }
}
