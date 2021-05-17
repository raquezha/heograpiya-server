package com.raquezha.heograpiya.models.lottie

import io.ktor.locations.*
import kotlinx.serialization.Serializable

@KtorExperimentalLocationsAPI
@Location("/splash")
@Serializable
data class Splash(
    val url: String,
    var active: Boolean = true
) {
    @Location("/active")
    object Active

    @Location("/all")
    object All
}