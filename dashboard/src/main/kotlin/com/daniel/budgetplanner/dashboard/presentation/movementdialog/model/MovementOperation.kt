package com.daniel.budgetplanner.dashboard.presentation.movementdialog.model

import androidx.compose.ui.graphics.Color
import com.daniel.base.ui.theme.BudgetGreen
import com.daniel.base.ui.theme.ExpensesColor
import com.daniel.budgetplanner.dashboard.domain.model.DbMovementType
import com.daniel.budgetplanner.dashboard.utils.ANT_EXPENSES
import com.daniel.budgetplanner.dashboard.utils.EXPENSE_TITLE
import com.daniel.budgetplanner.dashboard.utils.FOOD_EXPENSES
import com.daniel.budgetplanner.dashboard.utils.HEALTH_EXPENSES
import com.daniel.budgetplanner.dashboard.utils.INCOME_TITLE
import com.daniel.budgetplanner.dashboard.utils.MONTHLY_INCOMES
import com.daniel.budgetplanner.dashboard.utils.OTHER_INCOMES
import com.daniel.budgetplanner.dashboard.utils.OUTFIT_EXPENSES
import com.daniel.budgetplanner.dashboard.utils.SERVICES_EXPENSES
import com.daniel.budgetplanner.dashboard.utils.TRANSPORTATION_EXPENSES

enum class MovementOperation(
    val title: String,
    val movementColor: Color,
    val categoryList: List<String>,
    val dbMovementType: DbMovementType
) {
    INCOME_OPERATION(
        title = INCOME_TITLE,
        movementColor = BudgetGreen,
        categoryList = listOf(
            MONTHLY_INCOMES,
            OTHER_INCOMES
        ),
        dbMovementType = DbMovementType.INCOME
    ),
    EXPENSE_OPERATION(
        title = EXPENSE_TITLE,
        movementColor = ExpensesColor,
        categoryList = listOf(
            FOOD_EXPENSES,
            ANT_EXPENSES,
            SERVICES_EXPENSES,
            OUTFIT_EXPENSES,
            TRANSPORTATION_EXPENSES,
            HEALTH_EXPENSES
        ),
        dbMovementType = DbMovementType.EXPENSE
    )
}
