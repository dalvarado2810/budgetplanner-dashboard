package com.daniel.budgetplanner.dashboard.ui.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.daniel.budgetplanner.dashboard.R

@Composable
fun MovementsButtonRowComponent() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(
                top = dimensionResource(R.dimen.dimen_10dp),
                bottom = dimensionResource(R.dimen.dimen_10dp)
            )
            .fillMaxSize()
    ) {
        MovementButtonComponent(
            buttonIcon = R.drawable.ic_income_button,
            buttonText = stringResource(id = R.string.incomes),
            onButtonClick = { }
        )

        Spacer(
            modifier = Modifier
                .width(dimensionResource(R.dimen.dimen_38dp))
        )

        MovementButtonComponent(
            buttonIcon = R.drawable.ic_outcome_button,
            buttonText = stringResource(R.string.outcomes),
            onButtonClick = { }
        )
    }
}

@Preview(name = "MovementsButtonsComponent")
@Composable
fun PreviewMovementsButtonsComponent() {
    MovementsButtonRowComponent()
}
