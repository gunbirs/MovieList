package com.example.loadposter.models

data class Category(
    val alias: Alias,
    val appType: String,
    val corporateLinks: List<CorporateLink>,
    val dfpIUNumber: Int,
    val kidsAllowedScreens: List<Any>,
    val navigationLinks: List<NavigationLink>,
    val screens: List<Screen>,
    val title: String,
    val type: String
)