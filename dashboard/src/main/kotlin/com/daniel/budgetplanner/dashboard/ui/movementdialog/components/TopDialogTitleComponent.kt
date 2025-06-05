package com.daniel.budgetplanner.dashboard.ui.movementdialog.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.daniel.base.ui.theme.BudgetGreen
import com.daniel.budgetplanner.dashboard.R
import com.daniel.budgetplanner.dashboard.utils.DashboardTextStyles
import com.daniel.budgetplanner.dashboard.utils.INCOME

@Composable
fun TopDialogTitleComponent(
    modifier: Modifier = Modifier,
    title: String,
    color: Color
) {
    Surface(
        modifier = modifier
            .fillMaxWidth(),
        color = color,
        shape = RoundedCornerShape(
            topStart = dimensionResource(R.dimen.dimen_24dp),
            topEnd = dimensionResource(R.dimen.dimen_2dp)
        )
    ) {
        Text(
            text = title,
            color = Color.Black,
            modifier = Modifier
                .padding(vertical = dimensionResource(R.dimen.dimen_8dp)),
            style = DashboardTextStyles.text20spBoldAlign
        )
    }
}

@Preview(name = "TopDialogTitleComponent")
@Composable
fun PreviewTopDialogTitleComponent() {
    TopDialogTitleComponent(
        title = INCOME,
        color = BudgetGreen
    )
}
