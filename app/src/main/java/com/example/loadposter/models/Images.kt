package com.example.loadposter.models

import com.google.gson.annotations.SerializedName

data class Images(
    @SerializedName("bg tall") val bg_tall: List<String>,
    @SerializedName("bg wide") val bg_wide: List<String>,
    @SerializedName("clr logo") val clr_logo: List<String>,
    @SerializedName("clr logo 2") val clr_logo_2: List<String>,
    val cover: List<String>,
    val poster: List<String>,
    @SerializedName("pr-tser") val pr_tser: List<String>,
    @SerializedName("pr-tser-sm") val pr_tser_sm: List<String>,
    val square: List<String>,
    val thumbnail: List<String>
)