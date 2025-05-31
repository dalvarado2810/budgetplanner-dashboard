package com.daniel.budgetplanner.dashboard.presentation.home.action

import com.daniel.base.domain.usecase.UseCaseState
import com.daniel.base.presentation.Mutation
import com.daniel.base.presentation.action.ActionProcessor
import com.daniel.budgetplanner.dashboard.domain.usecases.EraseUserUseCase
import com.daniel.budgetplanner.dashboard.presentation.home.mvi.Home
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

private const val DELAY = 500L

class OnConfirmEraseUserActionProcessor(
    val eraseUserUseCase: EraseUserUseCase
) : ActionProcessor<Home.State, Home.Action.ConfirmEraseUser, Home.Effect>() {
    override fun process(
        action: Home.Action.ConfirmEraseUser,
        sideEffect: (Home.Effect) -> Unit
    ): Flow<Mutation<Home.State>> {
        return eraseUserUseCase.execute(Unit).map { useCaseState ->
            when(useCaseState){
                is UseCaseState.Data -> { currentState ->
                    currentState as Home.State.Content
                    CoroutineScope(Dispatchers.IO).launch {
                        delay(DELAY)
                        sideEffect(Home.Effect.NavigateToGetStarted)
                    }

                    currentState.copy(
                        isChangeUserDialogShown = false
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
