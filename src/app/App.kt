package app

import comp.account.candidate.cv.CandidateEditCV
import comp.account.UserAccountMain
import comp.main.MainPage
import react.*
import react.router.dom.*


class App : RComponent<RProps, RState>() {
    override fun RBuilder.render() {
        browserRouter {  // or "hashRouter"
            switch {
                // Лендинг с приглашением к регистрации
                route("/", MainPage::class, exact = true)
                route("/account", UserAccountMain::class, exact = true)
                route("/account/education", CandidateEditCV::class, exact = true)
                route("/account/personal",  CandidateEditCV::class, exact = true)
                route("/account/work_exp",  CandidateEditCV::class, exact = true)
                route("/account/will_work", CandidateEditCV::class, exact = true)
                route("/account/other",     CandidateEditCV::class, exact = true)
//                route("/account", strict = true) {
//                    div {
//
//                    }
//                }
//                +"HI login"
//                a(href = "/") {
//                    +"Back"
//                }
                redirect(from = "/redirect", to = "/redirected")
            }
        }
    }
}

fun RBuilder.app() = child(App::class) {}
