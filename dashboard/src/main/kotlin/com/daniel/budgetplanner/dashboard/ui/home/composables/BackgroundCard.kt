package com.daniel.budgetplanner.dashboard.ui.home.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.daniel.base.ui.theme.BudgetGreen
import com.daniel.budgetplanner.dashboard.R

@Composable
fun BackgroundCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(dimensionResource(R.dimen.dimen_347dp)),
        shape = RoundedCornerShape(
            bottomStart = dimensionResource(R.dimen.dimen_50dp),
            bottomEnd = dimensionResource(R.dimen.dimen_50dp)
        ),
        colors = CardDefaults.cardColors(
            containerColor = BudgetGreen
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = dimensionResource(R.dimen.dimen_8dp)
        ),
        content = { }
    )
}

@Preview
@Composable
fun BackgroundCardPreview() {
    BackgroundCard()
}
