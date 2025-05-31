package com.daniel.budgetplanner.dashboard.ui.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.daniel.budgetplanner.dashboard.utils.DashboardTextStyles
import com.daniel.budgetplanner.dashboard.utils.IMAGE_MOVEMENTS

@Composable
fun MovementButtonComponent(
    buttonIcon: Int,
    buttonText: String,
    onButtonClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .width(width = dimensionResource(R.dimen.dimen_142dp))
            .height(height = dimensionResource(R.dimen.dimen_65dp)),
        colors = CardDefaults.cardColors(containerColor = CardColor),
        elevation = CardDefaults.cardElevation(
            defaultElevation = dimensionResource(R.dimen.dimen_4dp)
        ),
        shape = RoundedCornerShape(size = dimensionResource(R.dimen.dimen_12dp)),
        onClick = onButtonClick
    ) {
        Row(
            modifier = Modifier.fillMaxHeight(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                modifier = Modifier
                    .size(dimensionResource(R.dimen.dimen_50dp))
                    .padding(start = dimensionResource(R.dimen.dimen_12dp)),
                painter = painterResource(id = buttonIcon),
                contentDescription = IMAGE_MOVEMENTS
            )

            Spacer(modifier = Modifier.width(dimensionResource(R.dimen.dimen_4dp)))

            Text(
                text = buttonText,
                style = DashboardTextStyles.text16spBolNoFonts
            )
        }
    }
}

@Preview
@Composable
fun MovementButtonComponentPreview() {
    MovementButtonComponent(
        buttonIcon = R.drawable.ic_income_button,
        buttonText = stringResource(R.string.incomes),
        onButtonClick = {  }
    )
}
