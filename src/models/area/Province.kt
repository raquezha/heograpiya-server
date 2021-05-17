package com.raquezha.heograpiya.models.area

import kotlinx.serialization.Serializable

@Serializable
data class Province(
    val province: String,
    val cityMuncipality: MutableList<CityMunicipality>
)