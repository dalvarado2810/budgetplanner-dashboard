package com.daniel.budgetplanner.dashboard.presentation.home.action

import com.daniel.base.domain.usecase.UseCaseState
import com.daniel.base.presentation.Mutation
import com.daniel.base.presentation.action.ActionProcessor
import com.daniel.budgetplanner.dashboard.domain.usecases.InitUseCase
import com.daniel.budgetplanner.dashboard.presentation.home.mvi.Home
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class OnInitActionProcessor(
    val initUseCase: InitUseCase
) : ActionProcessor<Home.State, Home.Action.Init, Home.Effect>() {
    override fun process(
        action: Home.Action.Init,
        sideEffect: (Home.Effect) -> Unit
    ): Flow<Mutation<Home.State>> {
        return initUseCase.execute(Unit).map { useCaseState ->
            when(useCaseState){
                is UseCaseState.Data -> { _ ->
                    val result = useCaseState.value
                    Home.State.Content(
                        name = result.userName,
                        rangeDates = result.rangeOfDates,
                        actualBalances = result.actualBalances,
                        movements = result.userMovements
                    )
                }
                is UseCaseState.Error -> { _ ->
                    Home.State.Error
                }
                is UseCaseState.Loading -> { _ ->
                    Home.State.Loading
                }
            }
        }
    }
}
