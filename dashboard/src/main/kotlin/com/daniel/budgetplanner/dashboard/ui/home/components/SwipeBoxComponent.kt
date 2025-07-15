package com.daniel.budgetplanner.dashboard.ui.home.components

import androidx.compose.animation.core.tween
import androidx.compose.animation.splineBasedDecay
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.AnchoredDraggableState
import androidx.compose.foundation.gestures.DraggableAnchors
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.anchoredDraggable
import androidx.compose.foundation.gestures.snapTo
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.daniel.base.ui.theme.BackGround
import com.daniel.base.ui.theme.BudgetGreen
import com.daniel.base.ui.theme.ExpensesColor
import com.daniel.budgetplanner.dashboard.R
import com.daniel.budgetplanner.dashboard.domain.model.Category
import com.daniel.budgetplanner.dashboard.presentation.home.model.DragState
import com.daniel.budgetplanner.dashboard.presentation.home.model.MovementItem
import com.daniel.budgetplanner.dashboard.utils.HALF_FLOAT
import com.daniel.budgetplanner.dashboard.utils.QUARTER_FLOAT
import com.daniel.budgetplanner.dashboard.utils.WEIGHT_ONE
import com.daniel.budgetplanner.dashboard.utils.ZERO_FLOAT
import kotlinx.coroutines.launch
import kotlin.math.roundToInt

@Composable
fun SwipeBoxComponent(
    modifier: Modifier = Modifier,
    onDelete: () -> Unit,
    onEdit: () -> Unit,
    content: @Composable () -> Unit
) {
    val scope = rememberCoroutineScope()
    val density = LocalDensity.current
    val decaySpec = remember { splineBasedDecay<Float>(density) }

    @Suppress("DEPRECATION")
    val state = remember {
        AnchoredDraggableState(
            initialValue = DragState.Settled,
            positionalThreshold = { distance -> distance * HALF_FLOAT },
            velocityThreshold = { with(density) { 100.dp.toPx() } },
            snapAnimationSpec = tween(),
            decayAnimationSpec = decaySpec
        )
    }

    Box(
        modifier = modifier
            .fillMaxWidth()
            .onSizeChanged { layoutSize ->
                val dragAmount = layoutSize.width * QUARTER_FLOAT
                val anchors = DraggableAnchors {
                    DragState.Settled at ZERO_FLOAT
                    DragState.StartRevealed at dragAmount
                    DragState.EndRevealed at -dragAmount
                }
                state.updateAnchors(anchors)
            }
    ) {
        Row(
            modifier = Modifier.matchParentSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                contentAlignment = Alignment.CenterStart,
                modifier = Modifier
                    .weight(WEIGHT_ONE)
                    .fillMaxHeight()
                    .background(BudgetGreen)
                    .clickable(enabled = state.currentValue == DragState.StartRevealed) {
                        scope.launch {
                            state.snapTo(DragState.Settled)
                            onEdit()
                        }
                    }
                    .padding(horizontal = dimensionResource(R.dimen.dimen_16dp))
            ) {
                if (state.targetValue == DragState.StartRevealed) {
                    Icon(
                        imageVector = Icons.Outlined.Edit,
                        contentDescription = stringResource(R.string.icon_description_modify)
                    )
                }
            }

            Box(
                contentAlignment = Alignment.CenterEnd,
                modifier = Modifier
                    .weight(WEIGHT_ONE)
                    .fillMaxHeight()
                    .background(ExpensesColor)
                    .clickable(enabled = state.currentValue == DragState.EndRevealed) {
                        scope.launch {
                            state.snapTo(DragState.Settled)
                            onDelete()
                        }
                    }
                    .padding(horizontal = dimensionResource(R.dimen.dimen_16dp))
            ) {
                if (state.targetValue == DragState.EndRevealed) {
                    Icon(
                        imageVector = Icons.Outlined.Delete,
                        contentDescription = stringResource(R.string.icon_description_delete)
                    )
                }
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .offset {
                    IntOffset(
                        x = state
                        .requireOffset()
                        .roundToInt(),
                        y = 0
                    )
                }
                .anchoredDraggable(state, orientation = Orientation.Horizontal)
                .background(when(state.currentValue){
                    DragState.Settled -> BackGround
                    DragState.StartRevealed -> BudgetGreen
                    DragState.EndRevealed -> ExpensesColor
                })
        ) {
            content()
        }
    }
}

@Preview(name = "SwipeBox")
@Composable
fun PreviewSwipeBoxComponent() {
    SwipeBoxComponent(
        onEdit = {},
        onDelete = {},
        content = {
            MovementItemComponent(
                item = MovementItem(
                    name = "Gasto de telefono para toda la familia",
                    category = Category.TRANSPORTATION_EXPENSES,
                    date = "25/05/25",
                    amount = "124250000"
                )
            )
        }
    )
}
