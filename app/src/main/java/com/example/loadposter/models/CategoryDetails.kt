package com.example.loadposter.models

data class CategoryDetails(
    val adScreenType: String,
    val adUnit: AdUnit,
    val alias: Alias,
    val collections: List<Collection>,
    val renderSecondaryNavTitleAs: String,
    val screenContentType: String,
    val screenType: String,
    val secondaryNavLinks: List<Any>,
    val secondaryNavTitleImage: Any,
    val secondaryNavTitleText: Any,
    val title: String,
    val type: String
)