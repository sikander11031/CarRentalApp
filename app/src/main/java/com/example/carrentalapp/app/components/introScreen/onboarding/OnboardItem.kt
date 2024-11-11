package com.example.carrentalapp.app.components.introScreen.onboarding

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.carrentalapp.app.data.model.OnBoardModel
import network.chaintech.sdpcomposemultiplatform.sdp
import network.chaintech.sdpcomposemultiplatform.ssp


@Composable
fun OnBoardItem(page: OnBoardModel) {
    val textTopMargin = 422.sdp
    val horizontalMargin = 19.sdp
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(page.image),
                contentScale = ContentScale.FillBounds
            )
    ) {
        val (textRef) = createRefs()
        Text(
            page.title,
            modifier = Modifier
                .constrainAs(textRef) {
                    top.linkTo(parent.top, margin = textTopMargin)
                    start.linkTo(parent.start, margin = horizontalMargin)
                    end.linkTo(parent.end, margin = 24.dp)
                    bottom.linkTo(parent.bottom)
                    width = Dimension.fillToConstraints

                }
                .size(165.sdp),
            textAlign = TextAlign.Center,
            color = Color.White,
            lineHeight = 20.ssp,
            fontSize = 16.ssp
        )


    }


}