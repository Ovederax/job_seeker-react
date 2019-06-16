package app

import react.*
import react.dom.*
import react.router.dom.*
import zcomponent_examples.ticker.Ticker


class App : RComponent<RProps, RState>() {
    override fun RBuilder.render() {
        browserRouter {  // or "hashRouter"
            switch {
                route("/", Ticker::class, exact = true)
                route("/login", strict = true) {
                    +"HI login"
                    a(href = "/") {
                        +"Back"
                    }
                }
                redirect(from = "/redirect", to = "/redirected")
            }
        }
    }
}

fun RBuilder.app() = child(App::class) {}
