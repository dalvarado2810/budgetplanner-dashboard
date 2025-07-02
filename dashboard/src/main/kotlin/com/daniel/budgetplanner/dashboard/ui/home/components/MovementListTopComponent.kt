package com.daniel.budgetplanner.dashboard.ui.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.daniel.budgetplanner.dashboard.R
import com.daniel.budgetplanner.dashboard.utils.DROPDOWN_IMAGE
import com.daniel.budgetplanner.dashboard.utils.DashboardTextStyles
import com.daniel.budgetplanner.dashboard.utils.WEIGHT_ONE
import com.daniel.budgetplanner.dashboard.utils.changeDateFormat

@Composable
fun MovementListTopComponent(
    startDate: String,
    endDate: String,
    onFilterCategoryClick: () -> Unit,
) {
    Row(
        horizontalArrangement = Arrangement.Start,
    ) {
        Text(
            modifier = Modifier
                .padding(
                    top = dimensionResource(R.dimen.dimen_4dp),
                    bottom = dimensionResource(R.dimen.dimen_6dp),
                    start = dimensionResource(R.dimen.dimen_24dp)),
            text = stringResource(
                id = R.string.dates,
                startDate.changeDateFormat(),
                endDate.changeDateFormat()
            ),
            color = Color.Black,
            style = DashboardTextStyles.text16spBoldStart
        )

        Spacer(modifier = Modifier.weight(WEIGHT_ONE))

        IconButton(
            onClick = onFilterCategoryClick,
            modifier = Modifier
                .padding(end = dimensionResource(R.dimen.dimen_24dp))
                .sizeIn(dimensionResource(R.dimen.dimen_48dp)),
        ) {
            Image(
                painterResource(id = R.drawable.ic_dropdown_menu),
                contentDescription = DROPDOWN_IMAGE,
                modifier = Modifier.sizeIn(dimensionResource(R.dimen.dimen_48dp))
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMovementListTopComponent() {
    MovementListTopComponent(
        startDate = "2025-05-12",
        endDate = "2025-06-20",
        onFilterCategoryClick = {}
    )
}
