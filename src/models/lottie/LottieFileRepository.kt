package com.raquezha.heograpiya.models.lottie

import io.ktor.locations.*

@KtorExperimentalLocationsAPI
class LottieFileRepository {
    private val records = mutableListOf<Splash>()

    val all: LottieFiles
        get() = LottieFiles(records)

    fun insert(url: String) {
        records.forEach {
            it.active = false
        }
        records += Splash(url = url, true)
    }

}

@KtorExperimentalLocationsAPI
val lottieRecord = LottieFileRepository().apply {
    insert("https://assets8.lottiefiles.com/private_files/lf30_qn7ozwlo.json")
    insert("https://assets7.lottiefiles.com/packages/lf20_t0mvxlwu.json")
}