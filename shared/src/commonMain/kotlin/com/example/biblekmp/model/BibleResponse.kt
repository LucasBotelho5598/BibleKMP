package com.example.biblekmp.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BibleResponse (
    @SerialName("data")
    val data: List<Bible>
)