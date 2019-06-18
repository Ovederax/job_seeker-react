package comp.account.candidate.cv

import kotlinx.html.InputType
import kotlinx.html.style
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.*


interface CandidateEditWillWorkProps : RProps {

}

interface CandidateEditWillWorkState : RState {

}

class CandidateEditWillWork(props: CandidateEditWillWorkProps) : RComponent<CandidateEditWillWorkProps, CandidateEditWillWorkState>(props) {
    override fun RBuilder.render() {
       div (classes = "intro") {
          div(classes = "container") {
             candidateEditCV(3, "Желаймая должность")

             div(classes = "cv_edit_area") {
                div(classes = "cv_edit_area_inner") {
                   table(classes = "cv__table") {
                      tr (classes = "cv_edit_area__item") {
                         td (classes = "w40percent ") {
                            +"Зарплата"
                         }
                         td {
                            input(classes = "w30percent margin_right_5px") {
                               /*attrs.placeholder.plus("0")*/
                            }
                            select(classes = "w20percent") {
                               option {
                                  +"Рублей"
                               }
                            }
                         }
                      }
                      tr (classes = "cv_edit_area__item") {
                         td { +"Город для работы" }
                         td {
                            input {  }
                         }
                      }
                      tr (classes = "cv_edit_area__item") {
                         td { +"Город для работы" }
                         td {
                            input {  }
                         }
                      }
                   }
                   button(classes = "cv_edit_area__btn margin_top_bottom_10px") {
                      /*attrs.style.plus("margin: 12px 0")*/
                      +"Добавить город"
                   }

                   table (classes = "cv__table") {
                      tr( classes = "cv_edit_area__item" ) {
                         td { +"Командировки" }
                         td {
                            select(classes = "w50percent") {
                               option { +"Возможны" }
                               option { +"Невозможны" }
                            }
                         }
                      }
                      tr( classes = "cv_edit_area__item" ) {
                         td { +"Тип занятости" }
                         td {
                            input (classes = "wh16px", type = InputType.checkBox) {
                            }
                            +"полная"
                         }
                         td {
                            input (classes = "wh16px", type = InputType.checkBox) {  }
                            +"частичная"
                         }
                      }
                      tr( classes = "cv_edit_area__item" ) {
                         td {  }
                         td {
                            input (classes = "wh16px", type = InputType.checkBox) {    }
                            +"вахтовая"
                         }
                         td {
                            input (classes = "wh16px", type = InputType.checkBox) {   }
                            +"временнная"
                         }
                      }

                      tr( classes = "cv_edit_area__item" ) {
                         td {  }
                         td {
                            input (classes = "wh16px", type = InputType.checkBox) {   }
                            +"стажировка"
                         }
                         td {  }
                      }

                      /*tr { td{ attrs.style.plus("height: 8px") } }*/
                      tr( classes = "cv_edit_area__item" ) {
                         td { +"График работы" }
                         td {
                            input (classes = "wh16px", type = InputType.checkBox) {
                            }
                            +"полный рабочий день"
                         }
                         td {
                            input (classes = "wh16px", type = InputType.checkBox) {}
                            +"удаленная"
                         }
                      }

                      tr( classes = "cv_edit_area__item" ) {
                         td {  }
                         td {
                            input (classes = "wh16px", type = InputType.checkBox) { }
                            +"гибкий"
                         }
                         td {
                            input (classes = "wh16px", type = InputType.checkBox) { }
                            +"сменный"
                         }
                      }
                   }
                }
             }

            div(classes = "cv_nav") {
               button (classes = "cvedit_btn") { +"Назад" }
               button (classes = "cvedit_btn") { +"Далее" }
            }
          }
       }
    }
}

fun RBuilder.candidateEditWillWork() = child(CandidateEditWillWork::class) {

}