package com.daniel.budgetplanner.dashboard.ui.home.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.daniel.base.ui.theme.BudgetGreen
import com.daniel.budgetplanner.dashboard.R
import com.daniel.budgetplanner.dashboard.utils.DashboardTextStyles

@Composable
fun ConfirmationButtonComponent(
    modifier: Modifier = Modifier,
    text: String,
    onButtonClickAction: () -> Unit
) {
    Button(
        onClick = onButtonClickAction,
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = dimensionResource(R.dimen.dimen_2dp)
        ),
        shape = RoundedCornerShape(corner = CornerSize(dimensionResource(R.dimen.dimen_8dp))),
        colors = ButtonDefaults.buttonColors(
            containerColor = BudgetGreen,
            contentColor = Color.Black
        ),
        modifier = modifier
            .width(width = dimensionResource(R.dimen.dimen_145dp))
            .height(height = dimensionResource(R.dimen.dimen_40dp)),
        contentPadding = PaddingValues(
            start = dimensionResource(R.dimen.dimen_24dp),
            end = dimensionResource(R.dimen.dimen_24dp)
        ),
        enabled = true
    ) {
        Text(
            text = text,
            style = DashboardTextStyles.text19spBlackCenter
        )
    }
}

@Preview(name = "ConfirmationButtonComponent")
@Composable
fun PreviewConfirmationButtonComponent() {
    ConfirmationButtonComponent(
        text = "Cancelar",
        onButtonClickAction = {}
    )
}
