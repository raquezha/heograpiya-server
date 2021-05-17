package com.raquezha.heograpiya

import com.raquezha.heograpiya.models.user.UserSession
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.locations.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.serialization.*
import io.ktor.server.netty.EngineMain.main
import io.ktor.sessions.*
import io.ktor.util.*
import kotlinx.css.CSSBuilder
import kotlinx.serialization.json.Json
import org.slf4j.event.Level
import kotlin.collections.set

fun main(args: Array<String>) {
    main(args)
}

@KtorExperimentalLocationsAPI
@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {

    install(Sessions) {
        cookie<UserSession>("HEOGRAPIYA_SESSION") {
            val secretEncryptKey = hex("00112233445566778899aabbccddeeff")
            val secretAuthKey = hex("02030405060708090a0b0c")
            cookie.extensions["SameSite"] = "lax"
            cookie.httpOnly = true
            transform(SessionTransportTransformerEncrypt(secretEncryptKey, secretAuthKey))
        }
    }
    install(AutoHeadResponse)

    install(Locations) {

    }

    install(CallLogging) {
        level = Level.INFO
        filter { call -> call.request.path().startsWith("/") }
    }

    install(CORS) {
        method(HttpMethod.Options)
        method(HttpMethod.Put)
        method(HttpMethod.Delete)
        method(HttpMethod.Patch)
        header(HttpHeaders.Authorization)
        allowCredentials = true
    }

    install(ContentNegotiation) {
        json(
            Json {
                prettyPrint = true
                isLenient = true
            }
        )
    }
//    // Configure ktor to use OAuth and register relevant routes
//    setupAuth()

    // Register application routes
    setupRoutes()
}

// Shortcut for the current session
val ApplicationCall.session: UserSession?
    get() = sessions.get<UserSession>()

suspend inline fun ApplicationCall.respondCss(builder: CSSBuilder.() -> Unit) {
    this.respondText(CSSBuilder().apply(builder).toString(), ContentType.Text.CSS)
}
