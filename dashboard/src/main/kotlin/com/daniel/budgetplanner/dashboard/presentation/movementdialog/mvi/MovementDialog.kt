package com.daniel.budgetplanner.dashboard.presentation.movementdialog.mvi

import com.daniel.base.presentation.ViewAction
import com.daniel.base.presentation.ViewEffect
import com.daniel.base.presentation.ViewState
import com.daniel.base.presentation.model.DoNotThrottle
import com.daniel.budgetplanner.dashboard.presentation.movementdialog.model.MovementDialogData
import com.daniel.budgetplanner.dashboard.presentation.movementdialog.model.MovementOperation
import java.time.LocalDate

object MovementDialog {
    sealed class State : ViewState() {
        data class Content(
            val movementOperation: MovementOperation,
            val descriptionText: String,
            val amountText: String,
            val dateSelected: LocalDate,
            val categorySelected: String,
            val isContinueButtonEnabled: Boolean,
            val isDatePickerShown: Boolean,
            val isCategoryPickerShown: Boolean
        ) : State()
    }

    sealed class Action : ViewAction() {
        @DoNotThrottle
        data class DescriptionChange(
            val descriptionText: String
        ) : Action()

        @DoNotThrottle
        data class AmountChange(
            val amountValue: String
        ) : Action()

        data object DateChangeIconClick : Action()

        data object DatePickerDismiss : Action()

        data class DateSelected(
            val date: LocalDate
        ) : Action()

        data class CategoryPickerClick(
            val isPick: Boolean
        ) : Action()

        data object CategoryPickerDismiss : Action()

        data class CategorySelected(
            val category: String
        ) : Action()

        data class SaveButtonClick(
            val movement: MovementDialogData
        ) : Action()

        data object CloseDialogIconClick : Action()
    }

    sealed class Effect : ViewEffect() {
        data object NavigateBackToHome : Effect()
    }
}
