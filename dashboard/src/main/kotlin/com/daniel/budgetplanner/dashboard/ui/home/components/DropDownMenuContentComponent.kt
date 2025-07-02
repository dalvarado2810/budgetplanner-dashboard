package com.daniel.budgetplanner.dashboard.ui.home.components

import androidx.compose.foundation.background
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import com.daniel.base.ui.theme.BackGround
import com.daniel.budgetplanner.dashboard.R
import com.daniel.budgetplanner.dashboard.utils.ALL_CATEGORIES
import com.daniel.budgetplanner.dashboard.utils.DashboardTextStyles
import com.daniel.budgetplanner.dashboard.utils.categories

@Composable
fun DropDownMenuContentComponent(
    isFilterCategoryMenuExpanded: Boolean,
    onFilterCategoryMenuDismiss: () -> Unit,
    onCategorySelected: (String) -> Unit
) {
    DropdownMenu(
        modifier = Modifier
            .background(BackGround),
        offset = DpOffset(
            dimensionResource(R.dimen.dimen_248dp),
            dimensionResource(R.dimen.dimen_0dp)
        ),
        expanded = isFilterCategoryMenuExpanded,
        onDismissRequest = onFilterCategoryMenuDismiss
    ) {
        DropdownMenuItem(
            onClick = {
                onCategorySelected(ALL_CATEGORIES)
            },
            text = {
                Text(
                    text = stringResource(id = R.string.all_categories),
                    style = DashboardTextStyles.text14spBold
                )
            }
        )

        categories.forEach { category ->
            DropdownMenuItem(
                onClick = {
                    onCategorySelected(category)
                },
                text = {
                    Text(
                        text = category,
                        style = DashboardTextStyles.text12spBlack
                    )
                }
            )
        }
    }
}

@Preview(name = "DropDownMenuContentComponent")
@Composable
fun PreviewDropDownMenuContentComponent() {
    DropDownMenuContentComponent(
        isFilterCategoryMenuExpanded = true,
        onFilterCategoryMenuDismiss = {},
        onCategorySelected = {}
    )
}
