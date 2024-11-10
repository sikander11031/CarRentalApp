package com.example.carrentalapp.app.presentation.intro.splash

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.carrentalapp.R

@Composable
fun SplashScreen() {

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.splash_bg_color))
            .paint(
                painterResource(R.drawable.splashbg),
                contentScale = ContentScale.FillBounds,
                alpha = 0.03f
            )
    ) {
        val (logoCarRef, logoAppRef) = createRefs()
        val verticalGuideline = remember { createGuidelineFromTop(0.2f) }
        val guideLineForCarLogo = remember { createGuidelineFromTop(0.65f) }
        Box(
            Modifier
                .wrapContentSize()
                .constrainAs(logoAppRef) {
                    top.linkTo(verticalGuideline)
                    start.linkTo(parent.start, margin = 65.dp)
                    end.linkTo(parent.end, margin = 65.dp)
                    width = Dimension.fillToConstraints
                }) {
            Image(
                painter = painterResource(R.drawable.chartercarlogo),
                contentDescription = "archaeological",
                modifier = Modifier
            )
        }
        Box(Modifier
            .wrapContentSize()
            .constrainAs(logoCarRef) {
                top.linkTo(guideLineForCarLogo)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                width = Dimension.fillToConstraints


            }


        ) {
            Image(
                painter = painterResource(R.drawable.carlogo),
                contentDescription = "CarLogo",
                modifier = Modifier

            )
        }

    }
}








