package com.example.loadposter.models

data class Content(
    val agvotCode: String,
    val alias: Alias,
    val availability: String,
    val axisCustomContentsCount: Int,
    val axisId: Int,
    val axisMainContentsCount: Int,
    val axisPromoContentsCount: Int,
    val defaultLangCode: String,
    val description: String,
    val featuredClip: Any,
    val featuredEpisode: Any,
    val firstAirYear: String,
    val flagLabel: Any,
    val flagTitle: Any,
    val flagVisibility: Boolean,
    val heroBrandLogoId: String,
    val images: Images,
    val mediaType: String,
    val originatingNetwork: Any,
    val originatingNetworkImages: OriginatingNetworkImages,
    val originatingNetworkLogoId: Any,
    val resourceCodes: List<String>,
    val scheduleEndDate: String,
    val scheduleStartDate: String,
    val seasons: List<Season>,
    val seasonsCount: Int,
    val subscriptionPackages: List<String>,
    val summary: String,
    val title: String,
    val type: String
)