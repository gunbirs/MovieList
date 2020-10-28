package com.example.loadposter.models

data class Season(
    val alias: Alias,
    val axisId: Int,
    val axisMediaAlias: AxisMediaAlias,
    val defaultLangCode: String,
    val endDate: String,
    val images: Images,
    val metadataUpgrade: List<MetadataUpgrade>,
    val name: String,
    val number: Int,
    val resourceCodes: List<String>,
    val startDate: String,
    val subscriptionPackages: List<String>,
    val type: String
)