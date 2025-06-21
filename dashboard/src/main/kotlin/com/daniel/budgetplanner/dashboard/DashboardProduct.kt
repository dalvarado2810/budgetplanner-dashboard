package com.daniel.budgetplanner.dashboard

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.dialog
import androidx.navigation.navigation
import androidx.navigation.toRoute
import com.daniel.base.Product
import com.daniel.budgetplanner.dashboard.data.utils.toMovement
import com.daniel.budgetplanner.dashboard.di.dashboardModule
import com.daniel.budgetplanner.dashboard.navigation.DashboardDestination
import com.daniel.budgetplanner.dashboard.presentation.home.route.HomeRoute
import com.daniel.budgetplanner.dashboard.presentation.movementdialog.route.MovementDialogRoute
import com.daniel.budgetplanner.dashboard.utils.EXPENSE
import com.daniel.budgetplanner.dashboard.utils.INCOME
import com.daniel.budgetplanner.onboarding.navigation.OnboardingDestination
import org.koin.core.module.Module

object DashboardProduct : Product() {
    override fun onInitNavigation(navController: NavController, navGraphBuilder: NavGraphBuilder) {
        navGraphBuilder.navigation<DashboardDestination.NavGraph>(
            startDestination = DashboardDestination.Home) {
                composable<DashboardDestination.Home> {
                    HomeRoute(
                        navigateToGetStarted = {
                            navController.navigate(OnboardingDestination.GetStarted)
                        },
                        navigateToHomeInit = {
                            navController.navigate(DashboardDestination.NavGraph)
                        },
                        navigateToIncomeDialog = {
                            navController.navigate(DashboardDestination.MovementDialog(INCOME))
                        },
                        navigateToExpenseDialog = {
                            navController.navigate(DashboardDestination.MovementDialog(EXPENSE))
                        },
                        navigateToEditMovementDialog = { movement ->
                            navController.navigate(
                                DashboardDestination.MovementDialog(
                                    movementOperation = movement.dbMovementType.toString(),
                                    isEditMode = true,
                                    id = movement.id,
                                    movementUser = movement.movementUser,
                                    movementDescription = movement.movementDescription,
                                    movementAmount = movement.movementAmount,
                                    movementCategory = movement.movementCategory.value,
                                    day = movement.date.dayOfMonth,
                                    month = movement.date.monthValue,
                                    year = movement.date.year
                                )
                            )
                        }
                    )
                }

                dialog<DashboardDestination.MovementDialog> { backStackEntry ->
                    val args = backStackEntry.toRoute<DashboardDestination.MovementDialog>()
                    val movement = if (!args.isEditMode) null else args.toMovement()

                    MovementDialogRoute(
                        operation = args.movementOperation,
                        isEditMovementDialog = args.isEditMode,
                        movement = movement,
                        navigateBackToHome = {
                            navController.navigate(DashboardDestination.NavGraph)
                        }
                    )
                }
        }
    }

    override fun getModules(): List<Module> {
        return listOf(
            dashboardModule
        )
    }
}
