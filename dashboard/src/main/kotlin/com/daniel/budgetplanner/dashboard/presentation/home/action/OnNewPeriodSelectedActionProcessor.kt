package com.daniel.budgetplanner.dashboard.presentation.home.action

import com.daniel.base.domain.usecase.UseCaseState
import com.daniel.base.presentation.Mutation
import com.daniel.base.presentation.action.ActionProcessor
import com.daniel.budgetplanner.dashboard.domain.usecases.NewPeriodSelectedUseCase
import com.daniel.budgetplanner.dashboard.domain.usecases.params.NewPeriodParams
import com.daniel.budgetplanner.dashboard.presentation.home.mvi.Home
import com.daniel.budgetplanner.dashboard.utils.EFFECT_DELAY
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class OnNewPeriodSelectedActionProcessor(
    private val newPeriodSelectedUseCase: NewPeriodSelectedUseCase
) : ActionProcessor<Home.State, Home.Action.OnNewPeriodSelected, Home.Effect>() {
    override fun process(
        action: Home.Action.OnNewPeriodSelected,
        sideEffect: (Home.Effect) -> Unit
    ): Flow<Mutation<Home.State>> {
        return newPeriodSelectedUseCase.execute(
            params = NewPeriodParams(
                startDate = action.startDate,
                endDate = action.endDate
            )
        ).map { useCaseState ->
            when(useCaseState) {
                is UseCaseState.Data -> { currentState ->
                    currentState as Home.State.Content
                    CoroutineScope(Dispatchers.IO).launch {
                        delay(EFFECT_DELAY)
                        sideEffect(Home.Effect.NavigateToHomeInit)
                    }
                    currentState.copy(
                        isDatePickerShown = false
                    )
                }
                is UseCaseState.Error -> { _ ->
                    Home.State.Error
                }
                is UseCaseState.Loading -> { currentState ->
                    currentState
                }
            }
        }
    }
}
