package com.raquezha.lottie

import kotlinx.serialization.Serializable

@Serializable
data class LottieFile(
    val description: String,
    val url: String,
    val active: Boolean
) {
    companion object {
        const val path = "/lottiefile"
    }
}