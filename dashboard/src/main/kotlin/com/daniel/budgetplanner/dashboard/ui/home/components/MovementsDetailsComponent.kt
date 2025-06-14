package com.daniel.budgetplanner.dashboard.ui.home.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import com.daniel.base.ui.theme.BudgetGreen
import com.daniel.budgetplanner.dashboard.R
import com.daniel.budgetplanner.dashboard.data.utils.toMovementItem
import com.daniel.budgetplanner.dashboard.domain.model.Category
import com.daniel.budgetplanner.dashboard.domain.model.DbMovementType
import com.daniel.budgetplanner.dashboard.domain.model.DomainMovements
import com.daniel.budgetplanner.dashboard.domain.model.Movement
import com.daniel.budgetplanner.dashboard.utils.ALL_CATEGORIES
import com.daniel.budgetplanner.dashboard.utils.GO_TO_TOP_IMAGE
import com.daniel.budgetplanner.dashboard.utils.WEIGHT_ONE
import kotlinx.coroutines.launch
import java.time.LocalDate

@Composable
fun MovementsDetailsComponent(
    dates: Pair<String, String>,
    categorySelected: String,
    movementsList: DomainMovements,
    isFilterCategoryMenuExpanded: Boolean,
    onFilterCategoryClick: () -> Unit,
    onFilterCategoryMenuDismiss: () -> Unit,
    onCategorySelected: (String) -> Unit,
    onEditMovement: (Movement) -> Unit,
    onDeleteMovement: (Movement) -> Unit
) {
    val comparator = Comparator<Movement> { a, b -> a.date.compareTo(b.date) }
    val coroutineScope = rememberCoroutineScope()
    val listState = rememberLazyListState()
    val isGoToTopEnabled by remember {
        derivedStateOf { listState.firstVisibleItemIndex > 0 }
    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MovementListTopComponent(
            startDate = dates.first,
            endDate = dates.second,
            onFilterCategoryClick = onFilterCategoryClick
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(WEIGHT_ONE)
        ) {
            DropDownMenuContentComponent(
                isFilterCategoryMenuExpanded = isFilterCategoryMenuExpanded,
                onCategorySelected = onCategorySelected,
                onFilterCategoryMenuDismiss = onFilterCategoryMenuDismiss
            )

            if (movementsList.isEmpty()) {
                EmptyStateComponent()
            } else {
                val filteredList = movementsList
                    .filter {
                        categorySelected == ALL_CATEGORIES ||
                        it.movementCategory.value == categorySelected
                    }
                    .sortedWith(comparator)
                if (filteredList.isEmpty()) {
                    EmptyStateComponent(isCategoryEmptyState = true)
                } else {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxWidth(),
                        state = listState
                    ) {
                        items(
                           filteredList
                        ) { item ->
                            SwipeBoxComponent(
                                onEdit = {
                                    onEditMovement(item)
                                },
                                onDelete = {
                                    onDeleteMovement(item)
                                }
                            ) {
                                MovementItemComponent(item = item.toMovementItem())
                            }
                        }
                    }
                }
            }
        }

        TextButton(
            modifier = Modifier
                .fillMaxWidth()
                .height(dimensionResource(R.dimen.dimen_40dp))
                .semantics {
                    contentDescription = GO_TO_TOP_IMAGE
                },
            enabled = isGoToTopEnabled,
            colors = ButtonDefaults.textButtonColors(
                contentColor = Color.Black,
                disabledContentColor = Color.Gray,
                containerColor = BudgetGreen,
                disabledContainerColor = BudgetGreen
            ),
            shape = RoundedCornerShape(
                topStart = dimensionResource(R.dimen.dimen_50dp),
                topEnd = dimensionResource(R.dimen.dimen_50dp)),
            onClick = {
                coroutineScope.launch {
                    listState.animateScrollToItem(0)
                }
            }
        ) {
            if (isGoToTopEnabled) {
                Text(
                    text = stringResource(id = R.string.go_to_first_movement)
                )
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun MovementsDetailsComponentPreview() {
    MovementsDetailsComponent(
        dates = Pair("2025-05-31", "2025-06-30"),
        categorySelected = "Todas las Categorías",
        movementsList = listOf(
            Movement(
                id = 12,
                movementDescription = "ingreso sueldo",
                movementCategory = Category.MONTHLY_INCOMES,
                movementAmount = 1500000,
                movementUser = "Daniel",
                dbMovementType = DbMovementType.INCOME,
                date = LocalDate.now(),
                month = 5,
                year = 2025
            )
        ),
        isFilterCategoryMenuExpanded = false,
        onFilterCategoryClick = {},
        onFilterCategoryMenuDismiss = {},
        onCategorySelected = {},
        onEditMovement = {},
        onDeleteMovement = {}
    )
}
