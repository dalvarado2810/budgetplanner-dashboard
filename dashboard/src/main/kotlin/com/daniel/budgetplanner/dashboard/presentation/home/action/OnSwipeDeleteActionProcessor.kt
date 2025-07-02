package com.daniel.budgetplanner.dashboard.presentation.home.action

import com.daniel.base.domain.usecase.UseCaseState
import com.daniel.base.presentation.Mutation
import com.daniel.base.presentation.action.ActionProcessor
import com.daniel.budgetplanner.dashboard.domain.usecases.DeleteMovementUseCase
import com.daniel.budgetplanner.dashboard.domain.usecases.params.DbOperationsParams
import com.daniel.budgetplanner.dashboard.presentation.home.mvi.Home
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class OnSwipeDeleteActionProcessor(
    val deleteMovementUseCase: DeleteMovementUseCase
) : ActionProcessor<Home.State, Home.Action.OnSwipeDelete, Home.Effect>() {
    override fun process(
        action: Home.Action.OnSwipeDelete,
        sideEffect: (Home.Effect) -> Unit
    ): Flow<Mutation<Home.State>> {
        return deleteMovementUseCase.execute(
            DbOperationsParams(
                userName = action.deleteAction.userName,
                rangeDates = action.deleteAction.rangeOfDate,
                movement = action.deleteAction.movement
            )
        ).map { useCaseState ->
            when(useCaseState) {
                is UseCaseState.Data -> { currentState ->
                    val result = useCaseState.value
                    currentState as Home.State.Content

                    currentState.copy(
                        actualBalances = result.actualBalances,
                        movements = result.userMovements
                    )
                }
                is UseCaseState.Error -> { currentState ->
                    currentState
                }
                is UseCaseState.Loading -> { currentState ->
                    currentState
                }
            }
        }
    }
}
