package com.daniel.budgetplanner.dashboard.ui.home.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.daniel.base.ui.theme.BudgetGreen
import com.daniel.budgetplanner.dashboard.R
import kotlinx.coroutines.delay

private const val ANIMATION_DELAY = 400

@Composable
fun LoadingAnimationComponent(
) {
    val circles = listOf(
        remember {
            Animatable(initialValue = 0.3f)
        },
        remember {
            Animatable(initialValue = 0.3f)
        },
        remember {
            Animatable(initialValue = 0.3f)
        }
    )

    circles.forEachIndexed { index, animatable ->
        LaunchedEffect(Unit) {
            delay(timeMillis = (ANIMATION_DELAY / circles.size).toLong() * index)

            animatable.animateTo(
                targetValue = 1f,
                animationSpec = infiniteRepeatable(
                    animation = tween(
                        durationMillis = ANIMATION_DELAY
                    ),
                    repeatMode = RepeatMode.Reverse
                )
            )
        }
    }

    Row(
        modifier = Modifier
            .fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        circles.forEachIndexed { index, animatable ->
            if (index != 0) {
                Spacer(modifier = Modifier.width(width = dimensionResource(R.dimen.dimen_6dp)))
            }

            Box(
                modifier = Modifier
                    .size(size = dimensionResource(R.dimen.dimen_36dp))
                    .clip(shape = CircleShape)
                    .background(
                        color = BudgetGreen
                            .copy(alpha = animatable.value)
                    ),
                content = {}
            )
        }
    }
}

@Preview(name = "LoadingAnimationComponent")
@Composable
fun PreviewLoadingAnimationComponent() {
    LoadingAnimationComponent()
}
