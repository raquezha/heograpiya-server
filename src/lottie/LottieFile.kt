package com.raquezha.lottie

import io.ktor.locations.*
import kotlinx.serialization.Serializable

@KtorExperimentalLocationsAPI
@Location("/splash/{url}/{description}")
@Serializable
data class LottieFile(
    val description: String,
    val url: String,
    var active: Boolean = true
) {
    companion object {
        const val path = "/lottiefiles"
    }
}