package com.raquezha.lottie

import io.ktor.locations.*
import kotlinx.serialization.Serializable

@Serializable
data class LottieFiles @KtorExperimentalLocationsAPI constructor(
    val lottieFiles: MutableList<LottieFile>
)