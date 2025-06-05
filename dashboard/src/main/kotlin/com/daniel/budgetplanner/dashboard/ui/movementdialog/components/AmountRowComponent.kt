package com.daniel.budgetplanner.dashboard.ui.movementdialog.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.text.isDigitsOnly
import com.daniel.base.ui.theme.ExpensesColor
import com.daniel.budgetplanner.dashboard.R
import com.daniel.budgetplanner.dashboard.utils.CurrencyVisualTransformation
import com.daniel.budgetplanner.dashboard.utils.DashboardTextStyles
import com.daniel.budgetplanner.dashboard.utils.MAX_AMOUNT
import com.daniel.budgetplanner.dashboard.utils.ZERO_STRING

@Composable
fun AmountRowComponent(
    amountText: String,
    color: Color,
    onAmountChange: (String) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.amount),
            style = DashboardTextStyles.text18spBoldBlack
        )

        Card(
            shape = RoundedCornerShape(dimensionResource(R.dimen.dimen_24dp)),
            elevation = CardDefaults.cardElevation(dimensionResource(R.dimen.dimen_2dp)),
            border = BorderStroke(dimensionResource(R.dimen.dimen_1dp), Color.Black)
        ) {
            TextField(
                value = amountText,
                onValueChange = { amount ->
                    if (amount.length <= MAX_AMOUNT &&
                        amount.isDigitsOnly() && amount.startsWith(ZERO_STRING)
                    ) onAmountChange(amount)
                },
                shape = RoundedCornerShape(dimensionResource(R.dimen.dimen_24dp)),
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Color.Black,
                    cursorColor = Color.White,
                    focusedContainerColor = color,
                    unfocusedContainerColor = color
                ),
                modifier = Modifier
                    .height(dimensionResource(R.dimen.dimen_60dp))
                    .align(Alignment.Start),
                textStyle = DashboardTextStyles.text18spBoldAlign,
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.NumberPassword,
                    imeAction = ImeAction.Done
                ),
                visualTransformation = CurrencyVisualTransformation()
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewAmountRowComponent() {
    AmountRowComponent(
        amountText = "1250000",
        color = ExpensesColor,
        onAmountChange = {}
    )
}
