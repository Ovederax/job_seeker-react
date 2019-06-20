package comp.modal

import comp.account.candidate.cv.gotoPageCandidateEdit
import comp.account.gotoPageAccount
import dto.RegistrationRequest
import kotlinx.html.js.onClickFunction
import org.w3c.dom.HTMLInputElement
import org.w3c.dom.HTMLSelectElement
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.button
import react.dom.div
import react.dom.findDOMNode
import react.dom.input
import rest.ServerAPI

interface RegModalProps : RProps {
    var exit: () -> Unit
}

interface RegModalState : RState {

}

class RegModal(props: RegModalProps) : RComponent<RegModalProps, RegModalState>(props)  {
    var refs:dynamic = null

    enum class FieldNames(val field: String) {
        Login("login"),
        Phone("phone"),
        Password("password")
    }

    override fun RBuilder.render() {
        div(classes = "modalDialog") {
            attrs["id"] = "register"
            div(classes = "popwin_reg") {
                div(classes = "popwin__inner") {
                    button(classes = "close") {
                        +"X"
                        attrs.onClickFunction = {props.exit()}
                    }
                    div(classes="intput_block") {
                        div {
                            div(classes = "input_title") {
                                +"Логин:"
                            }
                            input( classes = "popwin_input" ) {
                                attrs["ref"] = FieldNames.Login.field
                            }
                        }
                        div() {
                            div(classes = "input_title") { +"Телефон:" }
                            input( classes = "popwin_input" ) {
                                attrs["ref"] = FieldNames.Phone.field
                            }
                        }
                        div {
                            div(classes = "input_title") { +"Пароль:" }
                            input( classes = "popwin_input" ) {
                                attrs["ref"] = FieldNames.Password.field
                            }
                        }
                    }
                    div(classes = "popwin_bottom") {
                        button(classes = "popwin_btn") {
                            +"Создать аккаунт"
                            attrs.onClickFunction = {
                                val login      = (findDOMNode(refs[FieldNames.Login.field]) as HTMLInputElement).value
                                val phone      = (findDOMNode(refs[FieldNames.Phone.field]) as HTMLInputElement).value
                                val password   = (findDOMNode(refs[FieldNames.Password.field]) as HTMLInputElement).value
                                ServerAPI().register(JSON.stringify(RegistrationRequest(login, phone, password)),{
                                    //если cookie получено
                                    gotoPageAccount()
                                })
                            }
                        }
                    }
                }
            }
        }
    }

}

fun RBuilder.regModal(function: () -> Unit) = child(RegModal::class) {
    attrs.exit = function;
}
