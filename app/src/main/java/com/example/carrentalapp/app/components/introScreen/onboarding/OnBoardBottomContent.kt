package com.example.carrentalapp.app.components.introScreen.onboarding

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import network.chaintech.sdpcomposemultiplatform.sdp
import network.chaintech.sdpcomposemultiplatform.ssp


@Composable
fun OnBoardBottomContent(
    pages: List<Any>,
    pagerState: PagerState,
    onSkipClick: () -> Unit,
    onNextClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    ConstraintLayout(
        modifier
    ) {
        val (skipRef, indicatorRef, nextRef) = createRefs()
        Text(
            "SKIP",
            fontSize = 14.ssp,
            color = Color.White,
            modifier = Modifier
                .constrainAs(skipRef) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)

                }
                .clickable {
                    onSkipClick()
                }
        )
        ConstraintLayout(
            modifier = Modifier.constrainAs(indicatorRef) {
                top.linkTo(skipRef.top)
                bottom.linkTo(skipRef.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            },

            ) {
            val indicators = Array(pages.size) { createRef() }

            createHorizontalChain(*indicators, chainStyle = ChainStyle.Packed)

            repeat(pages.size) { index ->
                val isSelected = pagerState.currentPage == index

                Box(
                    modifier = Modifier
                        .constrainAs(indicators[index]) {
                            top.linkTo(parent.top)
                            bottom.linkTo(parent.bottom)
                        }
                        .padding(4.dp)
                        .width(if (isSelected) 14.sdp else 6.sdp)
                        .height(6.sdp)
                        .background(
                            color = if (isSelected) Color(0xFF2387E0) else Color.White,
                            shape = CircleShape
                        )
                        .animateContentSize()
                )
            }
        }
        Text(
            "NEXT",
            fontSize = 14.ssp,
            color = Color.White,
            modifier = Modifier
                .constrainAs(nextRef) {
                    top.linkTo(skipRef.top)
                    bottom.linkTo(skipRef.bottom)
                    end.linkTo(parent.end)

                }
                .clickable {
                    onNextClick()
                }
        )

    }


}