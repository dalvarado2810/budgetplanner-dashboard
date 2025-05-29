package com.daniel.budgetplanner.dashboard.presentation.home.action

import com.daniel.base.presentation.Mutation
import com.daniel.base.presentation.action.ActionProcessor
import com.daniel.budgetplanner.dashboard.domain.model.Category
import com.daniel.budgetplanner.dashboard.domain.model.DashboardBalances
import com.daniel.budgetplanner.dashboard.presentation.home.model.MovementItem
import com.daniel.budgetplanner.dashboard.presentation.home.mvi.Home
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

private const val DELAY_MILLIS = 3000L

class InitActionProcessor : ActionProcessor<Home.State, Home.Action.Init, Home.Effect>() {
    override fun process(
        action: Home.Action.Init,
        sideEffect: (Home.Effect) -> Unit
    ): Flow<Mutation<Home.State>> {
        return flow {
            delay(DELAY_MILLIS)
            emit {
                Home.State.Content(
                    name = "Daniel Alvarado",
                    actualBalances = DashboardBalances(
                        actualBalance = -200000000,
                        monthlyIncomeBalance = -342150,
                        otherIncomesBalance = 3500,
                        healthExpensesBalance = 4500,
                        foodExpensesBalance = 40000,
                        servicesExpensesBalance = 3400,
                        antExpensesBalance = 500,
                        outfitExpensesBalance = 10000,
                        transportExpensesBalance = 50000
                    ),
                    movements = listOf(
                        MovementItem(
                            name = "Gasto comun apartamento",
                            category = Category.SERVICES_EXPENSES,
                            date = "12/05/2025",
                            amount = "120000"
                        )
                    ),
                    rangeDates = Pair("12/05/2025", "12/06/2025"),
                    categorySelected = Category.SERVICES_EXPENSES.value,
                    isDatePickerShown = false,
                    isPolicyDialogShown = false,
                    isMenuShown = false,
                    isFilterShown = false,
                    isChangeUserDialogShown = false,
                    isBalanceVisible = false
                )
            }
        }
    }
}
