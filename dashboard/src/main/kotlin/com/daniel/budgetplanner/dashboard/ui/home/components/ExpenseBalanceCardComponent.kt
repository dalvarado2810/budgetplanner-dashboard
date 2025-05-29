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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.daniel.base.ui.theme.OnboardingBackground
import com.daniel.budgetplanner.dashboard.R
import com.daniel.budgetplanner.dashboard.utils.DashboardTextStyles
import com.daniel.budgetplanner.dashboard.utils.setActualBalanceColor
import com.daniel.budgetplanner.dashboard.utils.toFormattedAmount

@Composable
fun ExpenseBalanceCardComponent(
    expenseBalance: Int,
    isBalanceVisible: Boolean
) {
    Card(
        modifier = Modifier
            .padding(
                top = dimensionResource(R.dimen.dimen_4dp),
                start = dimensionResource(R.dimen.dimen_4dp)
            )
            .width(dimensionResource(R.dimen.dimen_110dp))
            .height(dimensionResource(R.dimen.dimen_47dp)),
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
                modifier = Modifier.padding(
                    top = dimensionResource(R.dimen.dimen_4dp),
                    bottom = dimensionResource(R.dimen.dimen_4dp)
                ),
                text = stringResource(id = R.string.food_balance),
                color = Color.Black,
                style = DashboardTextStyles.text10spBold
            )

            Text(
                modifier = Modifier,
                text = expenseBalance.toFormattedAmount(isBalanceVisible),
                color = setActualBalanceColor(expenseBalance),
                style = DashboardTextStyles.text12spBold,
            )
        }
    }
}

@Preview(name = "ExpenseBalanceCardComponent")
@Composable
fun PreviewExpenseBalanceCardComponent() {
    ExpenseBalanceCardComponent(
        expenseBalance = 240600,
        isBalanceVisible = true
    )
}
