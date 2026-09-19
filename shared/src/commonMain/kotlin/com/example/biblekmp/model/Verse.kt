package com.example.biblekmp.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Verse(
    @SerialName("data")
    val data: Data,
    @SerialName("meta")
    val meta: Meta
)