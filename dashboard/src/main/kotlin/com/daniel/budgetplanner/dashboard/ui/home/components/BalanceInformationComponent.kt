package com.daniel.budgetplanner.dashboard.ui.home.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.daniel.budgetplanner.dashboard.R
import com.daniel.budgetplanner.dashboard.domain.model.DashboardBalances
import com.daniel.budgetplanner.dashboard.utils.DashboardTextStyles
import com.daniel.budgetplanner.dashboard.utils.VISIBILITY_ICON
import com.daniel.budgetplanner.dashboard.utils.setActualBalanceColor
import com.daniel.budgetplanner.dashboard.utils.toFormattedAmount

@Composable
fun BalanceInformationComponent(
    balances: DashboardBalances,
    isBalanceVisible: Boolean,
    onToggleVisibility: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier
                .padding(top = dimensionResource(R.dimen.dimen_6dp)),
            text = stringResource(id = R.string.your_balance),
            color = Color.Black,
            style = LocalTextStyle.current.merge(
                DashboardTextStyles.balanceTextStyle
            )
        )

        Row {
            Text(
                modifier = Modifier
                    .height(dimensionResource(R.dimen.dimen_46dp)),
                text = balances.actualBalance.toFormattedAmount(isBalanceVisible),
                color = setActualBalanceColor(balances.actualBalance),
                style = DashboardTextStyles.text38spBold,
            )

            Icon(
                modifier = Modifier
                    .padding(
                        start = dimensionResource(R.dimen.dimen_24dp),
                        top = dimensionResource(R.dimen.dimen_8dp)
                    )
                    .clickable{
                        onToggleVisibility()
                    }
                    .size(dimensionResource(R.dimen.dimen_24dp)),
                painter = if (isBalanceVisible) painterResource(R.drawable.ic_visibility)
                    else painterResource(R.drawable.ic_visibility_off),
                contentDescription = VISIBILITY_ICON,
            )
        }

        BalancesStatusBarComponent(
            balances = balances,
            isBalanceVisible = isBalanceVisible
        )
    }
}

@Preview(
    name = "BalanceInformationComponent",
    showBackground = true
)
@Composable
fun PreviewBalanceInformationComponent() {
    BalanceInformationComponent(
        balances = DashboardBalances(
            actualBalance = -13350000,
            monthlyIncomeBalance = -342150,
            otherIncomesBalance = 3500,
            healthExpensesBalance = 4500,
            foodExpensesBalance = 40000,
            servicesExpensesBalance = 3400,
            antExpensesBalance = 500,
            outfitExpensesBalance = 10000,
            transportExpensesBalance = 50000
        ),
        isBalanceVisible = false,
        onToggleVisibility = {}
    )
}
