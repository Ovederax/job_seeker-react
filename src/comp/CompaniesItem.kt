package comp

import react.*
import react.dom.div

interface CompaniesItemProps : RProps {
    //json
}

interface CompaniesItemState : RState {

}

class CompaniesItem(props: CompaniesItemProps) : RComponent<CompaniesItemProps, CompaniesItemState>(props) {
    override fun RBuilder.render() {
        div(classes = "companies__item") {
            div {
                div(classes = "companies__item__prof") {
                    +"Менеджер проектов"
                }
                div(classes = "companies__item__company_name") {
                    +"ООО “Коркес-Боркес”"
                }
            }
            div(classes = "companies__item__price") {
                +"от 25 000 руб."
            }
        }
        div (classes = "companies__item__content") {
            div { +"Обязанности:" }
            div { +"• Активный поиск и привлечение новых клиентов (объектов)" }
            div { +"• Подготовка коммерческих предложений" }
            div { +"• Проведение переговоров" }
            div { +"• Проведение переговоров" }
            div { +"• Проведение переговоров" }
            div { +"• Заключение договоров" }
        }
    }
}

fun RBuilder.companiesItem() = child(CompaniesItem::class) {

}