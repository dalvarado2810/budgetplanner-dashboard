package com.daniel.budgetplanner.dashboard.ui.movementdialog.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.DatePickerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SelectableDates
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.daniel.base.ui.theme.BudgetGreen
import com.daniel.base.ui.theme.ExpensesColor
import com.daniel.budgetplanner.dashboard.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerView(
    datePickerState: DatePickerState
) {
    DatePicker(
        state = datePickerState,
        modifier = Modifier
            .background(BudgetGreen,
            RoundedCornerShape(
                dimensionResource(R.dimen.dimen_28dp)
            )
        ),
        title = {
            Text(
                modifier = Modifier
                    .padding(
                        start = dimensionResource(R.dimen.dimen_148dp),
                        top = dimensionResource(R.dimen.dimen_25dp)
                    ),
                text = stringResource(id = R.string.select_date)
            )
        },
        colors = DatePickerDefaults.colors(
            headlineContentColor = Color.Black,
            yearContentColor = Color.Black,
            selectedDayContainerColor = ExpensesColor,
            todayContentColor = ExpensesColor,
            todayDateBorderColor = ExpensesColor,
            disabledYearContentColor = Color.Black,
            currentYearContentColor = Color.Black,
            selectedYearContentColor = Color.Black,
            disabledSelectedYearContentColor = Color.Black
        ),
        showModeToggle = true
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun DatePickerComponentPreview() {
    DatePickerView(
        datePickerState = rememberDatePickerState(
            initialSelectedDateMillis = System.currentTimeMillis(),
            selectableDates = object : SelectableDates {
                override fun isSelectableDate(utcTimeMillis: Long): Boolean {
                    return utcTimeMillis <= System.currentTimeMillis()
                }
            }
        )
    )
}
