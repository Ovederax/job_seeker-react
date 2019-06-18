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
    }
}

fun RBuilder.mainPage() = child(MainPage::class) {

}
