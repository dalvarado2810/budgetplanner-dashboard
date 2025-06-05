package com.daniel.budgetplanner.dashboard.ui.movementdialog.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MenuAnchorType
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import com.daniel.base.ui.theme.ExpensesColor
import com.daniel.budgetplanner.dashboard.R
import com.daniel.budgetplanner.dashboard.presentation.movementdialog.model.MovementOperation

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategorySelectionRowComponent(
    color: Color,
    categorySelected: String,
    categoryList: List<String>,
    isCategoryPickerShown: Boolean,
    onCategoryPickerDismiss: () -> Unit,
    onCategoryPickerClick: (Boolean) -> Unit,
    onCategorySelected: (String) -> Unit
) {
    val keyboardController = LocalSoftwareKeyboardController.current

    Column(
        modifier = Modifier.padding(bottom = dimensionResource(R.dimen.dimen_6dp)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        ExposedDropdownMenuBox(
            expanded = isCategoryPickerShown,
            onExpandedChange = onCategoryPickerClick,
        ) {
            TextField(
                shape = RoundedCornerShape(dimensionResource(R.dimen.dimen_14dp)),
                modifier = Modifier.menuAnchor(MenuAnchorType.PrimaryEditable),
                readOnly = true,
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
                value = categorySelected,
                onValueChange = {},
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(
                        expanded = isCategoryPickerShown
                    )
                },
                colors = ExposedDropdownMenuDefaults.textFieldColors(
                    unfocusedContainerColor = color,
                    focusedContainerColor = color,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
            )

            ExposedDropdownMenu(
                expanded = isCategoryPickerShown,
                onDismissRequest = onCategoryPickerDismiss,
            ) {
                categoryList.forEach { selectionOption ->
                    DropdownMenuItem(
                        text = { Text(
                            text = selectionOption,
                            color = Color.Black)
                        },
                        onClick = {
                            onCategorySelected(selectionOption)
                            keyboardController?.hide()
                        },
                    )
                }
            }
        }
    }
}

@Preview(name = "CategorySelectionRowComponent")
@Composable
fun PreviewCategorySelectionRowComponent() {
    CategorySelectionRowComponent(
        color = ExpensesColor,
        categorySelected = "Alimentación",
        categoryList = MovementOperation.EXPENSE_OPERATION.categoryList,
        isCategoryPickerShown = true,
        onCategorySelected = {},
        onCategoryPickerClick = {},
        onCategoryPickerDismiss = {}
    )
}
