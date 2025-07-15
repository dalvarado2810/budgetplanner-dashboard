package com.daniel.budgetplanner.dashboard.ui.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.daniel.base.ui.theme.CardColor
import com.daniel.budgetplanner.dashboard.R
import com.daniel.budgetplanner.dashboard.domain.model.Category
import com.daniel.budgetplanner.dashboard.presentation.home.model.MovementItem
import com.daniel.budgetplanner.dashboard.utils.DashboardTextStyles
import com.daniel.budgetplanner.dashboard.utils.IMAGE_ICON_MOVEMENT_ITEM
import com.daniel.budgetplanner.dashboard.utils.TWO_MAX_LINES
import com.daniel.budgetplanner.dashboard.utils.WEIGHT_ONE
import com.daniel.budgetplanner.dashboard.utils.WEIGHT_TWO
import com.daniel.budgetplanner.dashboard.utils.WEIGHT_TWO_HALF
import com.daniel.budgetplanner.dashboard.utils.toAmountColor
import com.daniel.budgetplanner.dashboard.utils.toNumberFormat
import com.daniel.budgetplanner.dashboard.utils.toPainterResource

@Composable
fun MovementItemComponent(
    item: MovementItem
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(dimensionResource(R.dimen.dimen_90dp))
            .padding(
                horizontal = dimensionResource(R.dimen.dimen_12dp),
                vertical = dimensionResource(R.dimen.dimen_4dp)
            ),
        elevation = CardDefaults.cardElevation(dimensionResource(R.dimen.dimen_4dp)),
        colors = CardDefaults.cardColors(containerColor = CardColor)
    ) {
        Row(
            modifier = Modifier
                .padding(dimensionResource(R.dimen.dimen_12dp))
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.dimen_12dp)),
        ) {
            Image(
                painter = painterResource(id = item.category.toPainterResource()),
                contentDescription = IMAGE_ICON_MOVEMENT_ITEM,
                modifier = Modifier
                    .weight(WEIGHT_ONE)
                    .height(dimensionResource(R.dimen.dimen_50dp))
                    .width(dimensionResource(R.dimen.dimen_50dp))
                    .padding(dimensionResource(R.dimen.dimen_4dp))
            )

            Column(
                modifier = Modifier
                    .weight(WEIGHT_TWO),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = item.name,
                    maxLines = TWO_MAX_LINES,
                    style = DashboardTextStyles.text12spBoldRegular
                )

                Text(
                    text = item.category.value,
                    style = DashboardTextStyles.text10spMedium
                )

                Text(
                    text = item.date,
                    style = DashboardTextStyles.text10spMedium,
                    modifier = Modifier.padding( top = dimensionResource(R.dimen.dimen_2dp))
                )
            }

            Column(
                modifier = Modifier
                    .weight(WEIGHT_TWO_HALF)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(
                        id = R.string.item_amount,
                        item.amount.toInt().toNumberFormat()
                    ),
                    style = DashboardTextStyles.textAlign22spBold,
                    color = item.category.toAmountColor()
                )
            }
        }
    }
}

@Preview
@Composable
fun MovementItemComponentPreview(){
    MovementItemComponent(
        item = MovementItem(
            name = "Gasto de telefono para toda la familia",
            category = Category.TRANSPORTATION_EXPENSES,
            date = "25/05/25",
            amount = "124250000"
        )
    )
}
