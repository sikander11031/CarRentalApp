package com.example.carrentalapp.app.presentation.intro.onboarding

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.carrentalapp.R
import com.example.carrentalapp.app.components.introScreen.onboarding.OnBoardBottomContent
import com.example.carrentalapp.app.components.introScreen.onboarding.OnBoardItem
import com.example.carrentalapp.app.data.model.OnBoardModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import network.chaintech.sdpcomposemultiplatform.sdp

@Composable
fun OnBoardingScreen() {
    val pages = listOf(
        OnBoardModel(
            title = "Make it easy for users to quickly book a ride from their current location with just a few taps.",
            image = R.drawable.introone

        ),
        OnBoardModel(
            title = "Provide a variety of vehicle options to choose from, catering to different preferences and budgets.",
            image = R.drawable.onboardpagetwo

        ),
        OnBoardModel(
            title = "Let users track their ride in real-time, so they know exactly where their driver is and when they'll arrive.",
            image = R.drawable.onboardpagethree

        )
    )


    val pagerState = rememberPagerState {
        pages.size
    }
    val horizontalMargin = 28.sdp
    val coroutineScope = rememberCoroutineScope()
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {

        val (horizontalRef, bottomContentRef) = createRefs()
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxSize()
                .animateContentSize()
                .constrainAs(horizontalRef) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        ) { page ->
            OnBoardItem(pages[page])
        }
        OnBoardBottomContent(
            pages,
            pagerState,
            onNextClick = {
                coroutineScope.launch(Dispatchers.Main) {
                    if (pagerState.currentPage < pages.lastIndex) {
                        pagerState.animateScrollToPage(pagerState.currentPage + 1)
                    } else {
                        //add logic here where you want to navigate after pages survey complete
                    }
                }
            },
            onSkipClick = {
                coroutineScope.launch(Dispatchers.Main) {
                    pagerState.animateScrollToPage(pages.lastIndex)
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .constrainAs(bottomContentRef) {
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start, margin = horizontalMargin)
                    end.linkTo(parent.end, margin = horizontalMargin)
                    width = Dimension.fillToConstraints
                }
                .windowInsetsPadding(WindowInsets.systemBars)
        )

    }


}

