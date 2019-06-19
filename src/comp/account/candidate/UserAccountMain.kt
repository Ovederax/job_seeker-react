package comp.account

import kotlinx.html.js.onClickFunction
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.button
import react.dom.div
import kotlin.browser.window


/** Страница /account/ для Соискателя*/

interface UserAccountMainProps : RProps {

}

interface UserAccountMainState : RState {

}

fun gotoPageAccount() {
    window.location.href = "#/account"
}

class UserAccountMain(props: UserAccountMainProps) : RComponent<UserAccountMainProps, UserAccountMainState>(props) {
    override fun RBuilder.render() {
        div(classes = "intro") {
            div(classes = "container") {
                div(classes = "path") {
                    +"Главная / Личный кабинет"
                }

                div(classes = "cvedit__title") {
                    +"Личный кабинет"
                }

                div( classes =  "cvedit__text") {
                    div(classes = "marklist") {
                        +"Здесь вы можете: "
                        var items = arrayOf(
                                "- ознакомиться с услугами, которые предоставляет наш сервер",
                                "- произвести заполнение (редактирование) своего резюме",
                                "- увидеть отклики и приглашения",
                                "- познакомиться с компаниями, просмотревшими ваше резюме")

                        items.forEach {
                            div(classes = "marklist__item") {
                                +it
                            }
                        }
                    }
                }
                button(classes = "edit_my_cv_btn") {
                    +"Мое резюме"
                    attrs.onClickFunction = {
                        window.location.href="#/account/personal"
                    }
                }
            }
        }
    }
}

fun RBuilder.userAccount() = child(UserAccountMain::class) {

}
