package com.raquezha.heograpiya

import com.raquezha.heograpiya.models.area.Areas
import com.raquezha.heograpiya.models.area.areaRecord
import com.raquezha.heograpiya.models.lottie.Splash
import com.raquezha.heograpiya.models.lottie.lottieRecord
import io.ktor.application.*
import io.ktor.html.*
import io.ktor.http.content.*
import io.ktor.locations.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import kotlinx.css.Color
import kotlinx.css.em
import kotlinx.css.p
import kotlinx.html.body
import kotlinx.html.h1
import kotlinx.html.li
import kotlinx.html.ul

@KtorExperimentalLocationsAPI
fun Application.setupRoutes() = routing {

    post("/") {
        val text = call.receiveParameters()["text"]?.takeIf(String::isNotBlank)
            ?: throw Exception("Invalid request - text must be provided")

        lottieRecord.insert(text)

        call.respondRedirect("/")
    }

    get("/") {
        val username = call.parameters["username"]
        call.respondHtmlTemplate(MainTemplate(call.session?.username)) {
            content {
//                if (username == null) feedPage("🏠 Home feed", lottieRecord.all)
                 feedPage("Lottie Files", lottieRecord.all)
            }
        }
    }
        get("/html-dsl") {
            call.respondHtml {
                body {
                    h1 { +"HTML" }
                    ul {
                        for (n in 1..10) {
                            li { +"$n" }
                        }
                    }
                }
            }
        }

        get(Areas.path) {
            call.respond(areaRecord.all)
        }

        get("/styles.css") {
            call.respondCss {
                kotlinx.css.body {
                    backgroundColor = Color.red
                }
                p {
                    fontSize = 2.em
                }
                rule("p.myclass") {
                    color = Color.blue
                }
            }
        }

        // Static feature. Try to access `/static/ktor_logo.svg`
        static("/static") {
            resources("static")
        }

        get<Splash.All> {
            call.respond(lottieRecord.all)
        }

        get<Splash.Active> {
            val splash = lottieRecord.all.lottieFiles.first {
                it.active
            }
            call.respond(
                splash
            )
        }
    }