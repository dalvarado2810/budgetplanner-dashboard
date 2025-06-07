package com.daniel.budgetplanner.dashboard.di

import androidx.room.Room
import com.daniel.budgetplanner.dashboard.data.local.database.MovementDataBase
import com.daniel.budgetplanner.dashboard.data.repositories.MovementRepositoryImpl
import com.daniel.budgetplanner.dashboard.domain.repositories.MovementRepository
import com.daniel.budgetplanner.dashboard.domain.usecases.EraseUserUseCase
import com.daniel.budgetplanner.dashboard.domain.usecases.InitUseCase
import com.daniel.budgetplanner.dashboard.domain.usecases.NewPeriodSelectedUseCase
import com.daniel.budgetplanner.dashboard.domain.usecases.SaveMovementUseCase
import com.daniel.budgetplanner.dashboard.presentation.home.action.OnCancelEraseUserActionProcessor
import com.daniel.budgetplanner.dashboard.presentation.home.action.OnCategorySelectedActionProcessor
import com.daniel.budgetplanner.dashboard.presentation.home.action.OnInitActionProcessor
import com.daniel.budgetplanner.dashboard.presentation.home.action.OnMenuDismissActionProcessor
import com.daniel.budgetplanner.dashboard.presentation.home.action.OnNewPeriodMenuSelectionActionProcessor
import com.daniel.budgetplanner.dashboard.presentation.home.action.OnClickMenuActionProcessor
import com.daniel.budgetplanner.dashboard.presentation.home.action.OnConfirmEraseUserActionProcessor
import com.daniel.budgetplanner.dashboard.presentation.home.action.OnDatePickerDismissActionProcessor
import com.daniel.budgetplanner.dashboard.presentation.home.action.OnEraseUserMenuSelectionActionProcessor
import com.daniel.budgetplanner.dashboard.presentation.home.action.OnExpenseButtonClickActionProcessor
import com.daniel.budgetplanner.dashboard.presentation.home.action.OnFilterButtonClickActionProcessor
import com.daniel.budgetplanner.dashboard.presentation.home.action.OnFilterMenuDismissActionProcessor
import com.daniel.budgetplanner.dashboard.presentation.home.action.OnIncomeButtonClickActionProcessor
import com.daniel.budgetplanner.dashboard.presentation.home.action.OnNewPeriodSelectedActionProcessor
import com.daniel.budgetplanner.dashboard.presentation.home.action.OnPolicyClickActionProcessor
import com.daniel.budgetplanner.dashboard.presentation.home.action.OnPolicyDialogDismissActionProcessor
import com.daniel.budgetplanner.dashboard.presentation.home.action.OnToggleVisibilityActionProcessor
import com.daniel.budgetplanner.dashboard.presentation.home.viewmodel.HomeViewModel
import com.daniel.budgetplanner.dashboard.presentation.movementdialog.action.OnAmountChangeActionProcessor
import com.daniel.budgetplanner.dashboard.presentation.movementdialog.action.OnCategoryPickerClickActionProcessor
import com.daniel.budgetplanner.dashboard.presentation.movementdialog.action.OnCategoryPickerDismissActionProcessor
import com.daniel.budgetplanner.dashboard.presentation.movementdialog.action.OnCloseDialogIconClickActionProcessor
import com.daniel.budgetplanner.dashboard.presentation.movementdialog.action.OnDateChangeIconClickActionProcessor
import com.daniel.budgetplanner.dashboard.presentation.movementdialog.action.OnDateSelectedActionProcessor
import com.daniel.budgetplanner.dashboard.presentation.movementdialog.action.OnDescriptionChangeActionProcessor
import com.daniel.budgetplanner.dashboard.presentation.movementdialog.action.OnDialogCategorySelectedActionProcessor
import com.daniel.budgetplanner.dashboard.presentation.movementdialog.action.OnDialogDatePickerDismissActionProcessor
import com.daniel.budgetplanner.dashboard.presentation.movementdialog.action.OnSaveButtonClickActionProcessor
import com.daniel.budgetplanner.dashboard.presentation.movementdialog.viewmodel.MovementDialogViewModel
import com.daniel.budgetplanner.dashboard.utils.DB_MOVEMENTS
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import kotlin.jvm.java

val dashboardModule = module {
    // ViewModel
    viewModelOf(::HomeViewModel)
    viewModelOf(::MovementDialogViewModel)

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
    factoryOf(::OnNewPeriodSelectedActionProcessor)
    factoryOf(::OnFilterButtonClickActionProcessor)
    factoryOf(::OnFilterMenuDismissActionProcessor)
    factoryOf(::OnCategorySelectedActionProcessor)
    factoryOf(::OnIncomeButtonClickActionProcessor)
    factoryOf(::OnExpenseButtonClickActionProcessor)
    factoryOf(::OnCloseDialogIconClickActionProcessor)
    factoryOf(::OnDescriptionChangeActionProcessor)
    factoryOf(::OnAmountChangeActionProcessor)
    factoryOf(::OnDateChangeIconClickActionProcessor)
    factoryOf(::OnDialogDatePickerDismissActionProcessor)
    factoryOf(::OnDateSelectedActionProcessor)
    factoryOf(::OnCategoryPickerClickActionProcessor)
    factoryOf(::OnDialogCategorySelectedActionProcessor)
    factoryOf(::OnCategoryPickerDismissActionProcessor)
    factoryOf(::OnSaveButtonClickActionProcessor)

    // Use Cases
    factoryOf(::InitUseCase)
    factoryOf(::EraseUserUseCase)
    factoryOf(::NewPeriodSelectedUseCase)
    factoryOf(::SaveMovementUseCase)

    // Repositories
    singleOf(::MovementRepositoryImpl) { bind<MovementRepository>() }

    // Data Base
    single {
        Room.databaseBuilder(
            androidContext(),
            MovementDataBase::class.java,
            DB_MOVEMENTS
        ).build()
    }

    single {
        val db = get<MovementDataBase>()
        db.movementsDao
    }
}
