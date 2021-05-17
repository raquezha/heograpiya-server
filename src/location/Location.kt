package com.raquezha.location

import kotlinx.serialization.Serializable

@Serializable
data class Location(
    val locations: MutableList<Provinces>
)