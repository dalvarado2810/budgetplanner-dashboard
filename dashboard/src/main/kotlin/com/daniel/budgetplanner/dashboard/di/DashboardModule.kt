package com.daniel.budgetplanner.dashboard.di

import com.daniel.budgetplanner.dashboard.presentation.home.action.OnCancelEraseUserActionProcessor
import com.daniel.budgetplanner.dashboard.presentation.home.action.OnInitActionProcessor
import com.daniel.budgetplanner.dashboard.presentation.home.action.OnMenuDismissActionProcessor
import com.daniel.budgetplanner.dashboard.presentation.home.action.OnNewPeriodMenuSelectionActionProcessor
import com.daniel.budgetplanner.dashboard.presentation.home.action.OnClickMenuActionProcessor
import com.daniel.budgetplanner.dashboard.presentation.home.action.OnConfirmEraseUserActionProcessor
import com.daniel.budgetplanner.dashboard.presentation.home.action.OnDatePickerDismissActionProcessor
import com.daniel.budgetplanner.dashboard.presentation.home.action.OnEraseUserMenuSelectionActionProcessor
import com.daniel.budgetplanner.dashboard.presentation.home.action.OnPolicyClickActionProcessor
import com.daniel.budgetplanner.dashboard.presentation.home.action.OnPolicyDialogDismissActionProcessor
import com.daniel.budgetplanner.dashboard.presentation.home.action.OnToggleVisibilityActionProcessor
import com.daniel.budgetplanner.dashboard.presentation.home.viewmodel.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val dashboardModule = module {
    // ViewModel
    viewModelOf(::HomeViewModel)

    // Action Processors
    factoryOf(::OnInitActionProcessor)
    factoryOf(::OnToggleVisibilityActionProcessor)
    factoryOf(::OnClickMenuActionProcessor)
    factoryOf(::OnMenuDismissActionProcessor)
    factoryOf(::OnPolicyClickActionProcessor)
    factoryOf(::OnPolicyDialogDismissActionProcessor)
    factoryOf(::OnNewPeriodMenuSelectionActionProcessor)
    factoryOf(::OnDatePickerDismissActionProcessor)
    factoryOf(::OnEraseUserMenuSelectionActionProcessor)
    factoryOf(::OnConfirmEraseUserActionProcessor)
    factoryOf(::OnCancelEraseUserActionProcessor)

    // Use Cases
}
