package com.example.carrentalapp.app.presentation.intro.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.carrentalapp.R
import com.example.carrentalapp.utils.Orientation
import com.example.carrentalapp.utils.addMoveAnimation
import network.chaintech.sdpcomposemultiplatform.sdp

@Composable
fun SplashScreen() {
    // Use remember to avoid recomputation
    val appLogoMargin =  100.sdp
    val carLogoMargin = 35.sdp
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


        Box(
            Modifier
                .wrapContentSize()
                .constrainAs(logoAppRef) {
                    top.linkTo(parent.top, margin = appLogoMargin)
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

                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom, margin = carLogoMargin)
                width = Dimension.fillToConstraints


            }
            .addMoveAnimation(
                from = (-300).dp,
                to = 0.dp,
                orientation = Orientation.Horizontal,
                duration = 900
            )

        ) {
            Image(
                painter = painterResource(R.drawable.carlogo),
                contentDescription = "CarLogo",
                modifier = Modifier

            )
        }

    }
}






