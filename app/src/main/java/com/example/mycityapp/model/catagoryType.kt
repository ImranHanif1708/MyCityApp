package com.example.mycityapp.model

import androidx.annotation.DrawableRes

data class CityCategory(
    val name: String,
    @DrawableRes val imageResId: Int
)