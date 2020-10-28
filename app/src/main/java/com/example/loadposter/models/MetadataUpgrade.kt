package com.example.loadposter.models

data class MetadataUpgrade(
    val languages: List<String>,
    val packageName: String,
    val subText: Any,
    val userIsSubscribed: Boolean
)