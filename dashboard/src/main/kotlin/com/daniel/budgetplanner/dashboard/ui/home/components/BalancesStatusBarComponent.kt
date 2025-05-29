package com.daniel.budgetplanner.dashboard.ui.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.daniel.budgetplanner.dashboard.R
import com.daniel.budgetplanner.dashboard.domain.model.DashboardBalances

@Composable
fun BalancesStatusBarComponent (
    balances: DashboardBalances,
    isBalanceVisible: Boolean
) {
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = dimensionResource(R.dimen.dimen_4dp)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            IncomeBalanceCardComponent(
                incomeBalance = balances.monthlyIncomeBalance,
                isBalanceVisible = isBalanceVisible
            )

            IncomeBalanceCardComponent(
                incomeBalance = balances.otherIncomesBalance,
                isBalanceVisible = isBalanceVisible
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            ExpenseBalanceCardComponent(
                expenseBalance = balances.foodExpensesBalance,
                isBalanceVisible = isBalanceVisible
            )

            ExpenseBalanceCardComponent(
                expenseBalance = balances.healthExpensesBalance,
                isBalanceVisible = isBalanceVisible
            )

            ExpenseBalanceCardComponent(
                expenseBalance = balances.servicesExpensesBalance,
                isBalanceVisible = isBalanceVisible
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            ExpenseBalanceCardComponent(
                expenseBalance = balances.transportExpensesBalance,
                isBalanceVisible = isBalanceVisible
            )

            ExpenseBalanceCardComponent(
                expenseBalance = balances.outfitExpensesBalance,
                isBalanceVisible = isBalanceVisible
            )

            ExpenseBalanceCardComponent(
                expenseBalance = balances.antExpensesBalance,
                isBalanceVisible = isBalanceVisible
            )
        }
    }
}

@Preview
@Composable
fun BalancesStatusBarComponentPreview() {
    BalancesStatusBarComponent(
        balances = DashboardBalances(
            monthlyIncomeBalance = -342150,
            otherIncomesBalance = 3500,
            healthExpensesBalance = 4500,
            foodExpensesBalance = 40000,
            servicesExpensesBalance = 3400,
            antExpensesBalance = 500,
            outfitExpensesBalance = 10000,
            transportExpensesBalance = 50000
        ),
        isBalanceVisible = false
    )
}
