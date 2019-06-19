package comp.account.candidate.cv

import kotlinx.html.InputType
import kotlinx.html.js.onClickFunction
import kotlinx.html.style
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.*


interface CandidateEditWorkExpProps : RProps {

}

interface CandidateEditWorkExpState : RState {

}




class CandidateEditWorkExp(props: CandidateEditWorkExpProps) : RComponent<CandidateEditWorkExpProps, CandidateEditWorkExpState>(props) {
   private val pageId = 2

   override fun RBuilder.render() {
       div (classes = "intro") {
          div(classes = "container") {
             candidateEditCV(pageId, "Опыт работы")

             div(classes = "cv_edit_area") {
                div(classes = "cv_edit_area_inner") {
                   table(classes = "cv__table") {

                      val namesList = arrayOf(
                         "Компания", "Должность", "Город"
                      )
                      val placeholderList = arrayOf(
                           "Введите название компании", "Введите должность", "Выберите город"
                      )

                      for(iter in 0..2) {
                         tr (classes ="cv_edit_area__item") {
                            td {
                               +namesList[iter]
                               span (classes = "col_red") { +"*" }
                            }
                            td { input {
                               /*attrs.placeholder.plus(placeholderList[iter])*/
                            }
                            }
                         }
                      }

                      tr (classes ="cv_edit_area__item") {
                         td { +"Начало работы" }
                         td {
                            input(classes = "width_10percent margin_right_5px"){
                               /*attrs.placeholder.plus("Месяц")*/
                            }
                            input(classes = "width_14percent"){
                               /*attrs.placeholder.plus("Год")*/
                            }
                         }
                      }
                      tr (classes ="cv_edit_area__item") {
                         td { +"Конец работы" }
                         td {
                            input(classes = "width_10percent margin_right_5px") {
                               /*attrs.placeholder.plus("Месяц")*/
                            }
                            input(classes = "width_14percent"){
                               /*attrs.placeholder.plus("Год")*/
                            }
                         }
                      }
                      tr (classes ="cv_edit_area__item") {
                         td {  }
                         td {
                            input (classes = "wh16px", type = InputType.checkBox) { }
                            +"Работаю на данный момент"
                         }
                      }

                   }
                   div {
                      /*attrs.style.plus("margin: 18px 7px 0 ")*/
                      +"Обязанности и достижения"
                      span (classes = "col_red") { +"*" }
                   }

                   div(classes = "flex_row_container") {
                      div {
                         textArea(rows = "8", cols = "64") {
                            /*attrs.style.plus("font-size: 16px;")
                            attrs.placeholder.plus("Введите описание...")*/
                         }
                      }
                     button (classes = "add_work_exp") {
                        +"Добавить опыт работы"
                     }
                   }
                }
             }
             div (classes = "cv_nav") {
                button (classes = "cvedit_btn") {
                   attrs.onClickFunction = {
                      saveDate()
                      gotoPageCandidateEdit(pageId-1)
                   }
                   +"Назад"
                }
                button (classes = "cvedit_btn") {
                   attrs.onClickFunction = {
                      saveDate()
                      gotoPageCandidateEdit(pageId+1)
                   }
                   +"Далее"
                }
             }
          }
       }

    }

   private fun saveDate() {

   }
}

fun RBuilder.candidateEditWorkExp() = child(CandidateEditWorkExp::class) {

}
