package comp.main

import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.*

/**Главная страница лендинга*/

interface MainPageProps : RProps {

}

interface MainPageState : RState {

}

class MainPage(props: MainPageProps) : RComponent<MainPageProps, MainPageState>(props) {
    override fun RBuilder.render() {
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
                     img (src = "content/icons/exit.png") {  }
                  }
               }
            }
        }

        div("intro") {
            div("container") {
                div("intro__header") {
                    div("intro__title") {
                        div("intro__title-first") {
                            +"Самая тяжелая часть работы - найти работу."
                        }
                        div("intro__title-second") {
                            +"Мы поможем Вам!"
                        }
                    }
                    img(classes = "intro__img", src = "content/main/main.png") {  }
                }

                div("intro__variants") {
                    button(classes = "intro__button") { +"Найти работу" }
                    button(classes = "intro__button") { +"Предложить вакансию" }
                }

                div(classes = "intro__actual_info") {
                    div(classes = "actual_info__item") {
                        div(classes = "actual_info__title") {
                            +"Актуальные вакансии"
                        }
                        div(classes="actual_info__text") {
                            +"Lorem ipsum dolor sit amet, consectetur adipisicing elit. Error qui rerum molestiae incidunt optio vero, harum perspiciatis odit dignissimos cum repudiandae eaque recusandae autem accusantium et. Iure distinctio deleniti animi!"
                        }
                    }
                    div(classes = "actual_info__item") {
                        div(classes = "actual_info__title") {
                            +"Полезный материал"
                        }
                        div(classes="actual_info__text") {
                            +"Lorem ipsum dolor sit amet, consectetur adipisicing elit. Error qui rerum molestiae incidunt optio vero, harum perspiciatis odit dignissimos cum repudiandae eaque recusandae autem accusantium et. Iure distinctio deleniti animi!"
                        }
                    }
                    div(classes = "actual_info__item") {
                        div(classes = "actual_info__title") {
                            +"Новости"
                        }
                        div(classes="actual_info__text") {
                            +"Lorem ipsum dolor sit amet, consectetur adipisicing elit. Error qui rerum molestiae incidunt optio vero, harum perspiciatis odit dignissimos cum repudiandae eaque recusandae autem accusantium et. Iure distinctio deleniti animi!"
                        }
                    }
                }
            }
        }
        footer(classes = "footer") {
            div(classes = "footer__inner") {
                div(classes = "footer__copyright") {
                    +"© 2019 “JOB SEEKER”"
                }

                div(classes = "social") {
                    div(classes = "social__item") {
                        img(src="content/social/facebook.png", classes = "social__icon") {  }
                        a(classes = "basic_link social_link", href = "https://www.facebook.com", target = "_blank") {+"Facebook"}
                    }

                    div(classes = "social__item") {
                        img(src="content/social/twitter.png", classes = "social__icon") {  }
                        a(classes = "basic_link social_link", href = "https://twitter.com/?lang=ru", target = "_blank") {+"Twitter"}
                    }
                }

            }
        }
    }
}

fun RBuilder.mainPage() = child(MainPage::class) {

}
