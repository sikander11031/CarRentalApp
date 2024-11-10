package com.example.carrentalapp.app.presentation.intro.onboarding

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.carrentalapp.R

@Composable
fun OnBoardingScreen() {
    val pagerState = rememberPagerState() {
        3

    }




}

@Composable
fun OnBoardingPage() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(R.drawable.introone),
                contentScale = ContentScale.FillBounds
            )
    ) {

        

    }


}