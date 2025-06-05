package com.daniel.budgetplanner.dashboard.ui.movementdialog.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.daniel.base.ui.theme.BudgetGreen
import com.daniel.budgetplanner.dashboard.R
import com.daniel.budgetplanner.dashboard.utils.ICON_DATE
import com.daniel.budgetplanner.dashboard.utils.toViewPattern
import java.time.LocalDate

@Composable
fun DatePickerRowComponent(
    dateSelected: LocalDate,
    color: Color,
    onDateChangeIconClick: () -> Unit,
) {
    Button(
        onClick = { onDateChangeIconClick() },
        elevation = ButtonDefaults.elevatedButtonElevation(
            defaultElevation = dimensionResource(R.dimen.dimen_2dp)
        ),
        shape = RoundedCornerShape(
            corner = CornerSize(
                dimensionResource(R.dimen.dimen_48dp)
            )
        ),
        colors = ButtonDefaults.buttonColors(
            containerColor = color,
            contentColor = Color.Black
        ),
        modifier = Modifier
            .width(width = dimensionResource(R.dimen.dimen_155dp))
            .height(height = dimensionResource(R.dimen.dimen_40dp))
            .padding(
                top = dimensionResource(R.dimen.dimen_4dp),
                bottom = dimensionResource(R.dimen.dimen_4dp)
            ),
        contentPadding = PaddingValues(
            top = dimensionResource(R.dimen.dimen_4dp),
            start = dimensionResource(R.dimen.dimen_12dp),
            end = dimensionResource(R.dimen.dimen_12dp),
            bottom = dimensionResource(R.dimen.dimen_4dp)
        )
    ) {
        Image(
            painter = painterResource(
                id = R.drawable.ic_date_selector
            ),
            contentDescription = ICON_DATE,
            modifier = Modifier.padding(
                end = dimensionResource(R.dimen.dimen_6dp)
            ),
            alignment = Alignment.Center
        )
        Text(text = dateSelected.toViewPattern())
    }
}

@Preview(name = "DatePickerRowComponent")
@Composable
fun PreviewDatePickerRowComponent() {
    DatePickerRowComponent(
        dateSelected = LocalDate.now(),
        color = BudgetGreen,
        onDateChangeIconClick = {}
    )
}
