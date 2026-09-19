package com.example.biblekmp.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Bible(
    @SerialName("id")
    val id: String,
    @SerialName("bibleId")
    val bibleId: String,
    @SerialName("name")
    val name: String,
    @SerialName("abbreviation")
    val abbreviation: String

)

