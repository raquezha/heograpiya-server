package com.raquezha.location

import kotlinx.serialization.Serializable

@Serializable
data class Provinces(
    val province: String,
    val location: MutableList<String>
)