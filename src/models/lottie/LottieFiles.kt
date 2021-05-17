package com.raquezha.heograpiya.models.lottie

import io.ktor.locations.*
import kotlinx.serialization.Serializable

@Serializable
data class LottieFiles @KtorExperimentalLocationsAPI constructor(
    val lottieFiles: MutableList<Splash>
)