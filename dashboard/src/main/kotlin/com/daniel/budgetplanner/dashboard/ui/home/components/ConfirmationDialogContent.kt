package com.daniel.budgetplanner.dashboard.ui.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.daniel.base.ui.theme.OnboardingBackground
import com.daniel.budgetplanner.dashboard.R
import com.daniel.budgetplanner.dashboard.utils.DashboardTextStyles

@Composable
fun ConfirmationDialogContent(
    onPositiveAction: () -> Unit,
    onNegativeAction: () -> Unit
) {
    Column(
        modifier = Modifier
            .background(OnboardingBackground)
            .fillMaxWidth()
            .padding(dimensionResource(R.dimen.dimen_16dp))
    ) {
        Text(
            text = stringResource(id = R.string.confirmation_dialog_text),
            style = DashboardTextStyles.text22spBlackBoldCenter
        )

        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.dimen_16dp)))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            ConfirmationButtonComponent(
                text = stringResource(R.string.positive_option),
                onButtonClickAction = onPositiveAction
            )

            ConfirmationButtonComponent(
                text = stringResource(R.string.negative_option),
                onButtonClickAction = onNegativeAction
            )
        }
    }
}

@Preview
@Composable
fun Start(){
    ConfirmationDialogContent(
        onNegativeAction = {},
        onPositiveAction = {}
    )
}
