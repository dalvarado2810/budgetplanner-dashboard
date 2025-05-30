package com.daniel.budgetplanner.dashboard.ui.home.components

import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.daniel.base.ui.theme.BudgetGreen
import com.daniel.budgetplanner.dashboard.R

@Composable
fun ContinueButton(
    text: String,
    enabled: Boolean = true,
    onButtonClick: () -> Unit
) {
    Button(
        onClick = onButtonClick,
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = dimensionResource(R.dimen.dimen_2dp)
        ),
        shape = RoundedCornerShape(corner = CornerSize(dimensionResource(R.dimen.dimen_8dp))),
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.Black,
            containerColor = BudgetGreen,
            disabledContainerColor = Color.LightGray,
        ),
        modifier = Modifier
            .width(width = dimensionResource(R.dimen.dimen_325dp))
            .height(height = dimensionResource(R.dimen.dimen_60dp)),
        contentPadding = PaddingValues(
            top = dimensionResource(R.dimen.dimen_6dp),
            start = dimensionResource(R.dimen.dimen_32dp),
            end = dimensionResource(R.dimen.dimen_32dp)
        ),
        enabled = enabled
    ) {
        Text(
            text = text,
            color = Color.Black,
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontSize = 19.sp
            )
        )
    }
}

@Preview
@Composable
fun ContinueButtonPreview(){
    ContinueButton(
        text = "Continuar",
        onButtonClick = {}
    )
}
