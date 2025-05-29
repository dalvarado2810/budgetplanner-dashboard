package com.daniel.budgetplanner.dashboard.ui.home.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.daniel.base.ui.theme.BackGround
import com.daniel.budgetplanner.dashboard.R
import com.daniel.budgetplanner.dashboard.domain.model.Category
import com.daniel.budgetplanner.dashboard.domain.model.DashboardBalances
import com.daniel.budgetplanner.dashboard.presentation.home.model.MovementItem
import com.daniel.budgetplanner.dashboard.presentation.home.mvi.Home
import com.daniel.budgetplanner.dashboard.ui.home.components.BackgroundCard
import com.daniel.budgetplanner.dashboard.ui.home.components.BalanceInformationComponent
import com.daniel.budgetplanner.dashboard.ui.home.components.HomeTopRow

@Composable
fun HomeView(
    state: Home.State.Content,
    onToggleVisibility: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(BackGround)
    ) {
        BackgroundCard()

        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            HomeTopRow(
                modifier = Modifier
                    .padding(top = dimensionResource(R.dimen.dimen_16dp)),
                name = state.name,
                isMenuShown = state.isMenuShown,
                onMenuClick = {},
                onMenuDismiss = {},
                onChangeDateClick = {},
                onEraseUserClick = {},
                onPrivacyPolicyClick = {}
            )

            BalanceInformationComponent(
                balances = state.actualBalances,
                isBalanceVisible = state.isBalanceVisible,
                onToggleVisibility = onToggleVisibility
            )
        }
    }
}

@Preview
@Composable
fun DashboardViewPreview() {
    HomeView(
        state = Home.State.Content(
            name = "Daniel Alvarado",
            actualBalances = DashboardBalances(
                actualBalance = -200000,
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
        ),
        onToggleVisibility = {}
    )
}
