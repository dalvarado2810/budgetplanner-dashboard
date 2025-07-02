package com.daniel.budgetplanner.dashboard.ui.home.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConfirmationDialog(
    onPositiveAction: () -> Unit,
    onDismissAction: () -> Unit,
){
    val bottomSheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true
    )

    ModalBottomSheet(
        onDismissRequest = onDismissAction,
        sheetState = bottomSheetState,
    ) {
        ConfirmationDialogContent (
            onPositiveAction = onPositiveAction,
            onNegativeAction = onDismissAction
        )
    }
}
