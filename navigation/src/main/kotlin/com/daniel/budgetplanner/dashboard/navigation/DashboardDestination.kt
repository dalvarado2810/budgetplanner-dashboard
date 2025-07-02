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
        val movementOperation: String,
        val isEditMode: Boolean = false,
        val id: Int = 0,
        val movementDescription: String = "",
        val movementAmount: Int = 0,
        val dbMovementType: String = "",
        val movementUser: String = "",
        val movementCategory: String = "",
        val day: Int = 0,
        val month: Int = 0,
        val year: Int = 0
    ) : DashboardDestination()
}