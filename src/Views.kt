package com.raquezha.heograpiya

import com.raquezha.heograpiya.models.lottie.LottieFiles
import com.raquezha.heograpiya.models.lottie.Splash
import io.ktor.html.*
import io.ktor.locations.*
import kotlinx.html.*

/**
 * Generic web page template, contains content placeholder where
 * content should be placed
 */
class MainTemplate(private val currentUsername: String? = null) : Template<HTML> {
    val content = Placeholder<HtmlBlockTag>()

    override fun HTML.apply() {
        head {
            title { +"Heograpiya Simple Server" }
            styleLink("https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css")
            meta(name = "viewport", content = "width=device-width, initial-scale=1, shrink-to-fit=no")
            meta(charset = "utf-8")
        }
        body("d-flex flex-column h-100") {
            header {
                div("navbar navbar-dark bg-dark shadow-sm") {
                    div("container") {
                        a(href = "/", classes = "font-weight-bold navbar-brand") {
                            +"Heograpiya Test Server!"
                        }
                        div("navbar-nav flex-row") {
                            if (currentUsername != null) {
                                a(href = "/${currentUsername}", classes = "nav-link mr-4") {
                                    +"Hello, $currentUsername"
                                }
                                a(href = "/logout", classes = "nav-link") {
                                    +"Logout"
                                }
                            } else {
                                div("navbar-text mr-4") {
                                    +"Hello, Guest"
                                }
//                                div("navbar-item") {
//                                    a(href = "/login", classes = "nav-link") {
//                                        +"Login"
//                                    }
//                                }
                            }
                        }
                    }
                }
            }
            main("flex-shrink-0 mt-3") {
                div("container col-xs-12 col-lg-8") {
                    insert(content)
                }
            }
        }
    }
}

/**
 * Displays feed block only
 */
@KtorExperimentalLocationsAPI
fun FlowContent.feedBlock(feedItems: List<Splash>) {
    feedItems.forEach { record ->
        div("entity card m-4") {
            div("w-100 card-header") {
                h4("user font-weight-bold mb-0 pb-0 d-inline-block") {
                    if(record.active) {
                        +"Active: "
                    } else {
                        +"Inactive"
                    }

                }
                span("float-right text-secondary") {
                    +"isActive? ${record.active}"
                }
            }
            div("card-body") {
                h5 { +record.url }
            }
        }
    }
}

fun FlowContent.addNewLottieFile() {
    form("/", encType = FormEncType.applicationXWwwFormUrlEncoded, method = FormMethod.post) {
        div("mb-3") {
            div("input-group") {
                input(classes = "form-control", name = "text") {
                    placeholder = "Input new lottie splash url"
                    required = true
                    autoFocus = true
                }
                div("input-group-append") {
                    button(classes = "btn btn-success") { +"Add! 🚀" }
                }
            }
        }
    }
}

/**
 * Renders feed page with given title and records
 */
@KtorExperimentalLocationsAPI
fun FlowContent.feedPage(title: String, records: LottieFiles) {
    addNewLottieFile()
    hr { }
    h2("text-center") { +title }
    feedBlock(
        records.lottieFiles.sortedByDescending {
            it.active
        }
    )
}