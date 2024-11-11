package com.example.carrentalapp.app.data.model

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable

@Stable
@Immutable
data class OnBoardModel(

    @DrawableRes val image: Int,
    val title: String,
)
