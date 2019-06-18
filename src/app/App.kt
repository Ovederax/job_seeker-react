package app

import comp.account.userAccount
import comp.account.candidate.cv.*
import comp.main.container
import comp.main.mainPage
import react.*
import react.router.dom.*


class App : RComponent<RProps, RState>() {
    override fun RBuilder.render() {
        hashRouter {   // or "hashRouter"
            switch {
                // Лендинг с приглашением к регистрации
                route("/",  exact = true) {
                    container(::mainPage)
                }
                route("/account", exact = true) {
                    container(::userAccount)
                }
                route("/account/education", exact = true) {
                    container(::candidateEditEdu)
                }
                route("/account/personal", exact = true) {
                    container(::candidateEditPersonal)
                }
                route("/account/work_exp", exact = true) {
                    container(::candidateEditWorkExp)
                }
                route("/account/will_work", exact = true) {
                    container(::candidateEditWillWork)
                }
                route("/account/other", exact = true) {
                    container(::candidateEditOther)
                }
                redirect(from = "/redirect", to = "/redirected")
            }
        }
    }
}

fun RBuilder.app() :ReactElement {
    return child(App::class) {}
}
