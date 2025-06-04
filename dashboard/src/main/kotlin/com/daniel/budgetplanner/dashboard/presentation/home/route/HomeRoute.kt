package com.daniel.budgetplanner.dashboard.presentation.home.route

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.daniel.base.utils.extension.CollectEffectWithLifecycle
import com.daniel.budgetplanner.dashboard.presentation.home.mvi.Home
import com.daniel.budgetplanner.dashboard.presentation.home.viewmodel.HomeViewModel
import com.daniel.budgetplanner.dashboard.ui.home.screen.HomeScreen
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeRoute(
    viewModel: HomeViewModel = koinViewModel(),
    navigateToGetStarted: () -> Unit,
    navigateToHomeInit: () -> Unit
) {
    val viewState by viewModel.state.collectAsStateWithLifecycle()

    CollectEffectWithLifecycle(flow = viewModel.effect) { effect ->
        when (effect) {
            is Home.Effect.NavigateToExpenseDialog -> TODO()
            is Home.Effect.NavigateToIncomeDialog -> TODO()
            is Home.Effect.NavigateToGetStarted -> navigateToGetStarted()
            is Home.Effect.NavigateToHomeInit -> navigateToHomeInit()
        }
    }

    HomeScreen(
        state = viewState,
        onToggleVisibility = viewModel::onToggleVisibilityAction,
        onMenuClick = viewModel::onMenuClickAction,
        onMenuDismiss = viewModel::onMenuDismissAction,
        onEraseUserClick = viewModel::onEraseUserClickAction,
        onPrivacyPolicy = viewModel::onPolicyButtonClickAction,
        onPrivacyPolicyDismiss = viewModel::onPolicyDialogDismissAction,
        onDateChange = viewModel::onDatePickerClickAction,
        onDatePickerDismiss = viewModel::onDatePickerDismissAction,
        onNewPeriodSelected = { startDate, endDate ->
            viewModel.onNewPeriodSelected(
                startDate = startDate,
                endDate = endDate
            )
        },
        onChangeUserConfirmation = viewModel::onConfirmEraseUserAction,
        onChangeUserDialogDismiss = viewModel::onCancelEraseUserAction,
        onIncomeButtonClick = {},
        onExpenseButtonClick = {},
        onFilterMenuClick = viewModel::onFilterButtonClickAction,
        onFilterMenuDismiss = viewModel::onFilterMenuDismissAction,
        onFilterCategorySelected = viewModel::onCategorySelectedAction
    )

}
