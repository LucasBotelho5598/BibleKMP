package com.example.biblekmp.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ChapterResponse(
    @SerialName("data")
    val data: List<Chapter>
)
