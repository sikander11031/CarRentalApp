package com.example.carrentalapp.utils

import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.unit.Dp


sealed class Orientation {
    data object Vertical : Orientation()
    data object Horizontal : Orientation()
}

fun Modifier.addMoveAnimation(
    orientation: Orientation,
    from: Dp,
    to: Dp,
    duration: Int
): Modifier = composed {
    var isAtStart by remember { mutableStateOf(true) }

    LaunchedEffect(Unit) {
        isAtStart = !isAtStart
    }

    val targetValue by remember {
        derivedStateOf { if (isAtStart) from else to }
    }

    val animatedOffset by animateDpAsState(
        targetValue = targetValue,
        animationSpec = TweenSpec(durationMillis = duration)
    )

    when (orientation) {
        is Orientation.Vertical -> this.offset(y = animatedOffset)
        is Orientation.Horizontal -> this.offset(x = animatedOffset)
    }
}

