package com.daniel.budgetplanner.dashboard.di

import androidx.room.Room
import com.daniel.budgetplanner.dashboard.data.local.database.MovementDataBase
import com.daniel.budgetplanner.dashboard.data.repositories.MovementRepositoryImpl
import com.daniel.budgetplanner.dashboard.domain.repositories.MovementRepository
import com.daniel.budgetplanner.dashboard.domain.usecases.EraseUserUseCase
import com.daniel.budgetplanner.dashboard.domain.usecases.InitUseCase
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
    factoryOf(::InitUseCase)
    factoryOf(::EraseUserUseCase)

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
