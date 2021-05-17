package com.raquezha.lottie

import kotlinx.serialization.Serializable

@Serializable
data class LottieFiles(
    val lottieFiles: MutableList<LottieFile>
)