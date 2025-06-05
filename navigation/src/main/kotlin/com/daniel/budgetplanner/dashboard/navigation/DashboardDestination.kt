package com.daniel.budgetplanner.dashboard.navigation

import com.daniel.base.presentation.model.Destination
import kotlinx.serialization.Serializable

@Serializable
sealed class DashboardDestination : Destination() {
    @Serializable
    data object NavGraph : DashboardDestination()

    @Serializable
    data object Home : DashboardDestination()

    @Serializable
    data class MovementDialog(
        val movementOperation: String
    ) : DashboardDestination()
}