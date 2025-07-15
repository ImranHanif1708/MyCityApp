package com.example.mycityapp.model

import androidx.annotation.DrawableRes
sealed class CitySpecials(
    open val title: String,
    open val desc : String,
    @DrawableRes open val imageResId: Int,
)
// Represents a cuisine with its name, description, and image resource IDs.
data class Cuisine(
    override val title: String,
    override val desc: String,
    @DrawableRes override val imageResId: Int,
) : CitySpecials(
    title = title,
    desc = desc,
    imageResId = imageResId
)

// Represents a tourist attraction with its name, description, and image resource IDs.
data class ReligiousSites(
    override val title: String,
    override val desc: String,
    @DrawableRes override val imageResId: Int,
): CitySpecials(
    title = title,
    desc = desc,
    imageResId = imageResId
)

// Represents a tourist attraction with its name, description, and image resource IDs.
data class Museums(
    override val title: String,
    override val desc: String,
    @DrawableRes override val imageResId: Int,
): CitySpecials(
    title = title,
    desc = desc,
    imageResId = imageResId
)