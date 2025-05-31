package com.daniel.budgetplanner.dashboard.ui.home.screen

import androidx.compose.runtime.Composable
import com.daniel.budgetplanner.dashboard.presentation.home.mvi.Home
import com.daniel.budgetplanner.dashboard.ui.home.view.HomeLoadingView
import com.daniel.budgetplanner.dashboard.ui.home.view.HomeView
import java.time.LocalDate

@Composable
fun HomeScreen(
    state: Home.State,
    onToggleVisibility: () -> Unit,
    onMenuClick: () -> Unit,
    onMenuDismiss: () -> Unit,
    onEraseUserClick: () -> Unit,
    onPrivacyPolicy: () -> Unit,
    onPrivacyPolicyDismiss: () -> Unit,
    onDateChange: () -> Unit,
    onDatePickerDismiss: () -> Unit,
    onNewPeriodSelected: (LocalDate?, LocalDate?) -> Unit,
    onChangeUserConfirmation: () -> Unit,
    onChangeUserDialogDismiss: () -> Unit,
    onIncomeButtonClick: () -> Unit,
    onExpenseButtonClick: () -> Unit
) {
    when (state) {
        is Home.State.Content -> {
            HomeView(
                state = state,
                onToggleVisibility = onToggleVisibility,
                onMenuClick = onMenuClick,
                onMenuDismiss = onMenuDismiss,
                onDateChange = onDateChange,
                onEraseUserClick = onEraseUserClick,
                onPrivacyPolicy = onPrivacyPolicy,
                onPrivacyPolicyDismiss = onPrivacyPolicyDismiss,
                onNewPeriodSelected = onNewPeriodSelected,
                onDatePickerDismiss = onDatePickerDismiss,
                onChangeUserDialogDismiss = onChangeUserDialogDismiss,
                onChangeUserConfirmation = onChangeUserConfirmation,
                onIncomeButtonClick = onIncomeButtonClick,
                onExpenseButtonClick = onExpenseButtonClick
            )
        }
        is Home.State.Error -> {}
        is Home.State.Loading -> {
            HomeLoadingView()
        }
    }
}
