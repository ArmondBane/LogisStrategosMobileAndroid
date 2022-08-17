package com.goodcomp.core.domain.entity

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize

@Parcelize
data class Stratagem(
    val name: String,
    val description: String,
    val faction: String,
    val style: String,
    val cost: String,
    val effect: String,
    @DrawableRes val picture: Int,
) : Parcelable {

    fun getNumberCost(): List<Int> =
        cost.split("/").map {
            it.replace("CP", "")
            it.toIntOrNull() ?: 0
        }
}