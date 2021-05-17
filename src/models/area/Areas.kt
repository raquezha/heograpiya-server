package com.raquezha.heograpiya.models.area

import kotlinx.serialization.Serializable

@Serializable
data class Areas(
    val locations: MutableList<Province>
) {
    companion object {
        const val path = "/areas"
    }
}