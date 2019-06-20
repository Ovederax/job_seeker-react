package comp.modal

import comp.account.gotoPageAccount
import dto.LoginRequest
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
import rest.Client
import rest.ServerAPI


interface AuthModalProps : RProps {
    var exit: () -> Unit
}

interface AuthModalState : RState {

}

class AuthModal(props: AuthModalProps) : RComponent<AuthModalProps, AuthModalState>(props)  {
    var refs:dynamic = null

    enum class FieldNames(val field: String) {
        Phone("phone"),
        Password("password")
    }

    override fun RBuilder.render() {
        div(classes = "modalDialog") {
            attrs["id"] = "login"
            div(classes = "popwin_reg") {
                div(classes = "popwin__inner") {
                    button(classes = "close") {
                        +"X"
                        attrs.onClickFunction = { props.exit() }
                    }
                    div(classes="intput_block") {
                        div() {
                            div(classes = "input_title") { +"Email:" }
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
                            +"Вход"
                            attrs.onClickFunction = {
                                val phone      = (findDOMNode(refs[FieldNames.Phone.field]) as HTMLInputElement).value
                                val password   = (findDOMNode(refs[FieldNames.Password.field]) as HTMLInputElement).value
                                ServerAPI().login(JSON.stringify(LoginRequest(phone, password)),{
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

fun RBuilder.authModal(func: ()->Unit) = child(AuthModal::class) {
    attrs.exit = func
}