package com.example.carrentalapp.app.presentation.intro.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
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
                alpha = 0.05f
            )
    ) {
        val (logoCarRef, logoAppRef) = createRefs()
        val verticalGuideline = remember { createGuidelineFromTop(0.2f) }
        val guideLineForCarLogo = remember { createGuidelineFromTop(0.65f) }
        Image(
            painter = painterResource(R.drawable.chartercarlogo),
            contentDescription = "archaeological",
            modifier = Modifier.constrainAs(logoAppRef) {
                top.linkTo(verticalGuideline)
                start.linkTo(parent.start, margin = 65.dp)
                end.linkTo(parent.end, margin = 65.dp)
                width = Dimension.fillToConstraints
            }
        )
        Image(
            painter = painterResource(R.drawable.carlogo),
            contentDescription = "CarLogo",
            modifier = Modifier
                .constrainAs(logoCarRef) {
                top.linkTo(guideLineForCarLogo)
                start.linkTo(parent.start)
                end.linkTo(parent.end)

            }
        )
    }
}




