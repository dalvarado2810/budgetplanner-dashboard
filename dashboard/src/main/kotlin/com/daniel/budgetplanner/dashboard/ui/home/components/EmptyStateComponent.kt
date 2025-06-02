package com.daniel.budgetplanner.dashboard.ui.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.daniel.budgetplanner.dashboard.R
import com.daniel.budgetplanner.dashboard.utils.DashboardTextStyles
import com.daniel.budgetplanner.dashboard.utils.IMAGE_NO_MOVEMENTS

@Composable
fun EmptyStateComponent(
    isCategoryEmptyState: Boolean = false,
) {
    val textResource = if (isCategoryEmptyState) {
        R.string.no_movements_add
    } else {
        R.string.no_categories_movements_add
    }
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_no_transactions),
            contentDescription = IMAGE_NO_MOVEMENTS
        )

        Text(
            modifier = Modifier
                .padding(top = dimensionResource(R.dimen.dimen_6dp)),
            text = stringResource(id = textResource),
            style = DashboardTextStyles.text14spMediumBlack
        )
    }
}

@Preview(showBackground = true)
@Composable
fun NoMovementsItemComponentPreview(){
    EmptyStateComponent()
}
