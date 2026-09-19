package com.example.biblekmp

import io.ktor.util.Platform

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform