package com.daniel.budgetplanner.dashboard

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.daniel.base.Product
import com.daniel.budgetplanner.dashboard.di.dashboardModule
import com.daniel.budgetplanner.dashboard.navigation.DashboardDestination
import com.daniel.budgetplanner.dashboard.presentation.home.route.HomeRoute
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
