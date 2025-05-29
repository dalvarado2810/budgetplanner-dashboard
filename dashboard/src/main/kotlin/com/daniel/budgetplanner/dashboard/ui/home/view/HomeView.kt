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
import com.daniel.budgetplanner.dashboard.ui.home.composables.BackgroundCard
import com.daniel.budgetplanner.dashboard.ui.home.composables.HomeTopRow

@Composable
fun HomeView(
    state: Home.State.Content
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
        }
    }
}

@Preview
@Composable
fun DashboardViewPreview() {
    HomeView(
        state = Home.State.Content(
            name = "Daniel Alvarado",
            actualBalances = DashboardBalances(),
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
            isChangeUserDialogShown = false
        )
    )
}
