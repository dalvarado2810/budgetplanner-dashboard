package com.daniel.budgetplanner.dashboard.ui.home.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.daniel.base.ui.theme.OnboardingBackground
import com.daniel.budgetplanner.dashboard.R
import com.daniel.budgetplanner.dashboard.utils.DashboardTextStyles
import com.daniel.budgetplanner.dashboard.utils.setActualBalanceColor
import com.daniel.budgetplanner.dashboard.utils.toFormattedAmount

@Composable
fun IncomeBalanceCardComponent(
    title: String,
    incomeBalance: Int,
    isBalanceVisible: Boolean
) {
    Card(
        modifier = Modifier
            .padding(
                top = dimensionResource(R.dimen.dimen_4dp),
                start = dimensionResource(R.dimen.dimen_4dp)
            )
            .width(dimensionResource(R.dimen.dimen_165dp))
            .height(dimensionResource(R.dimen.dimen_57dp)),
        shape = RoundedCornerShape(dimensionResource(R.dimen.dimen_8dp)),
        colors = CardDefaults.cardColors(
            containerColor = OnboardingBackground
        ),
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier
                    .padding(
                        top = dimensionResource(R.dimen.dimen_4dp),
                        bottom = dimensionResource(R.dimen.dimen_6dp)
                    ),
                text = title,
                style = DashboardTextStyles.text10spBold
            )

            Text(
                modifier = Modifier,
                text = incomeBalance.toFormattedAmount(isBalanceVisible),
                color = setActualBalanceColor(incomeBalance),
                style = DashboardTextStyles.text16spBold,
            )
        }
    }
}

@Preview(name = "BalanceAmountCard")
@Composable
fun PreviewBalanceAmountCard() {
    IncomeBalanceCardComponent(
        title = "Ingreso Mensual",
        incomeBalance = 250000,
        isBalanceVisible = false
    )
}
