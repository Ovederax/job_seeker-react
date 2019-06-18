package comp.main

import comp.modal.authModal
import comp.modal.regModal
import kotlinx.html.js.onClickFunction
import react.*
import react.dom.*
import kotlin.browser.window

interface ContainerProps : RProps {
    //var inner: RComponent<P, T>
    var block: () -> ReactElement
}

interface ContainerState : RState {
    var authVisible: Boolean
    var regVisible: Boolean
}

class Container(props: ContainerProps) : RComponent<ContainerProps, ContainerState>(props) {
    override fun componentDidMount() {
        state.authVisible = false
        state.regVisible = false
    }
    fun setAuthVisible(visible: Boolean) {
        setState {
            authVisible = visible
        }
    }
    fun setRegVisible(visible: Boolean) {
        //var loc = window.location.href;
        setState {
            regVisible = visible
            //window.location.href = loc;
        }
    }
    override fun RBuilder.render() {
        div(classes = "content") {
            if(state.regVisible) {
                regModal {setRegVisible(false)}
            }
            if(state.authVisible) {
                authModal({setAuthVisible(false)})
            }
            header ("header"){
                div("header__inner") {
                    div("header__logo") {
                        img(classes = "logo__img", src = "content/icons/logo.png") {}
                        div(classes = "logo__text") { +"JOB SEEKER"}
                    }

                    nav("nav") {
                        a("#", classes = "nav__link") { +"Поиск работы" }
                        a("#", classes = "nav__link") { +"Новая вакансия" }
                        a("#", classes = "nav__link") { +"Компании" }
                        a("#", classes = "nav__link") {
                            +"Вход"
                            attrs.onClickFunction = {
                                setAuthVisible(true)
                            }
                        }
                        a("#", classes = "nav__link") {
                            +"Регистрация"
                            attrs.onClickFunction = {
                                setRegVisible(true)
                            }
                        }
                    }
                }
            }
            this.child(props.block())
        }

        footer (classes = "footer") {
            div (classes = "footer__inner") {
                div(classes = "footer__copyright") {
                    +"© 2019 “JOB SEEKER”"
                }
                div(classes = "social") {
                    div(classes = "social__item") {
                        img(src = "content/social/facebook.png", classes = "social__icon") {  }
                        a(href = "https://www.facebook.com", target = "_blank", classes = "basic_link social_link") { +"Facebook" }
                    }
                    div(classes = "social__item") {
                        img(src = "content/social/twitter.png", classes = "social__icon") {  }
                        a(href = "https://twitter.com/?lang=ru", target = "_blank", classes = "basic_link social_link") { +"Facebook" }
                    }
                }
            }
        }
    }
}

fun RBuilder.container(block: () -> ReactElement) = child(Container::class) {
    attrs.block = block;
}
