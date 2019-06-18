package comp.modal

import kotlinx.html.js.onClickFunction
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.button
import react.dom.div
import react.dom.input

interface RegModalProps : RProps {
    var exit: () -> Unit
}

interface RegModalState : RState {

}

class RegModal(props: RegModalProps) : RComponent<RegModalProps, RegModalState>(props)  {
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
                            input( classes = "popwin_input" ) {  }
                        }
                        div() {
                            div(classes = "input_title") { +"Email:" }
                            input( classes = "popwin_input" ) {  }
                        }
                        div {
                            div(classes = "input_title") { +"Пароль:" }
                            input( classes = "popwin_input" ) {  }
                        }
                    }
                    div(classes = "popwin_bottom") {
                        button(classes = "popwin_btn") {
                            +"Создать аккаунт"
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
