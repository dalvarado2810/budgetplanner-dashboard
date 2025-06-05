package com.daniel.budgetplanner.dashboard.ui.movementdialog.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.tooling.preview.Preview
import com.daniel.base.ui.theme.BudgetGreen
import com.daniel.budgetplanner.dashboard.R
import com.daniel.budgetplanner.dashboard.utils.DashboardTextStyles
import com.daniel.budgetplanner.dashboard.utils.ICON_CLOSE
import com.daniel.budgetplanner.dashboard.utils.MAX_INPUT

@Composable
fun DescriptionRowComponent(
    text: String,
    color: Color,
    onDescriptionChange: (String) -> Unit,
    onCloseClick: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = stringResource(id = R.string.description),
                style = DashboardTextStyles.text18spBoldBlack
            )

            Spacer(
                modifier = Modifier
                    .width(
                        dimensionResource(R.dimen.dimen_32dp)
                    )
            )

            IconButton(
                onClick = {
                    onCloseClick()
                },
                modifier = Modifier
                    .padding(start = dimensionResource(R.dimen.dimen_64dp))
                    .align(Alignment.CenterVertically)
            ) {
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = ICON_CLOSE,
                    tint = Color.Black,
                )
            }
        }

        Card(
            shape = RoundedCornerShape(dimensionResource(R.dimen.dimen_24dp)),
            elevation = CardDefaults.cardElevation(dimensionResource(R.dimen.dimen_2dp)),
            border = BorderStroke(dimensionResource(R.dimen.dimen_1dp), Color.Black)
        ) {
            TextField(
                value = text,
                onValueChange = { description ->
                    if (description.length <= MAX_INPUT) onDescriptionChange(description)
                },
                shape = RoundedCornerShape(dimensionResource(R.dimen.dimen_24dp)),
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Color.Black,
                    cursorColor = Color.White,
                    focusedContainerColor = color,
                    unfocusedContainerColor = color,
                ),
                singleLine = true,
                modifier = Modifier
                    .height(dimensionResource(R.dimen.dimen_60dp))
                    .align(Alignment.CenterHorizontally),
                textStyle = DashboardTextStyles.text18spBoldAlign,
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Done
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DescriptionRowComponentPreview() {
    DescriptionRowComponent(
        text = "Compra de supermercado para fiesta",
        color = BudgetGreen,
        onDescriptionChange = {},
        onCloseClick = {}
    )
}
