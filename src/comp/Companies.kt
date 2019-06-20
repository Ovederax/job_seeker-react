package comp

import react.*
import react.dom.div
import react.dom.option
import react.dom.select
import react.dom.span

interface CompaniesProps : RProps {

}

interface CompaniesState : RState {

}

class Companies(props: CompaniesProps) : RComponent<CompaniesProps, CompaniesState>(props) {
    var vacanciesFound = 1222;
    var averagePay = 23422;
    override fun RBuilder.render() {
        div(classes = "companies") {
            div(classes = "container") {
                div(classes = "companies__header") {
                    div(classes = "companies__header__top") {
                        span(classes = "companies__header__title") {
                            +"Работа в Омске"
                        }
                        span(classes = "companies__header__found") {
                            +"найдено вакансий: $vacanciesFound"
                        }
                    }
                    div(classes = "") {+"Средняя зарплата по городу: $averagePay"}
                }
                div(classes = "companies__header__sort") {
                    select {
                        option {
                            +"Сортировка: по дате"
                        }
                    }
                    select {
                        option {
                            +"Период: сутки"
                        }
                    }
                }
                div(classes = "companies__content") {
                    companiesItem()
                }
            }
        }
    }
}

fun RBuilder.companies() = child(Companies::class) {

}