package comp.account.candidate.cv

import kotlinx.html.js.onClickFunction
import kotlinx.html.style
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.*
import kotlin.browser.window

interface CandidateEditEduProps : RProps {

}

interface CandidateEditEduState : RState {

}

class CandidateEditEdu(props: CandidateEditEduProps) : RComponent<CandidateEditEduProps, CandidateEditEduState>(props) {
   val pageId = 1;
   override fun RBuilder.render() {
        div (classes = "intro"){
            div(classes = "container") {
               candidateEditCV(pageId, "Образование")
               div(classes = "cv_edit_area") {
                  div(classes = "cv_edit_area_inner") {
                     table(classes = "cv__table") {
                        tr (classes = "cv_edit_area__item") {
                           td { +"Уровень образования" }
                           td {
                              select {
                                 option() {+"Высшее"}
                              }
                           }
                        }

                        tr (classes = "cv_edit_area__item") {
                           td { +"Город" }
                           td {
                              input {  }
                           }
                        }
                        tr (classes = "cv_edit_area__item") {
                           td { +"Учебное заведение" }
                           td {
                              input {  }
                           }
                        }

                        tr (classes = "cv_edit_area__item") {
                           td { +"Факультет" }
                           td {
                              input {  }
                           }
                        }

                        tr (classes = "cv_edit_area__item") {
                           td { +"Специальность" }
                           td {

                           }
                        }

                        tr (classes = "cv_edit_area__item") {
                           td { +"Форма обучения" }
                           td {
                              select () {
                                 option { +"Очная" }
                                 option { +"Заочная" }
                                 option { +"Очно-Заочная" }
                                 option { +"Дистанционная" }
                              }
                           }
                        }

                        tr (classes = "cv_edit_area__item") {
                           td { +"Начало обучения" }
                           td {
                              input {
                                 /*attrs {
                                    placeholder.plus("Год")
                                 }*/
                              }
                           }
                        }

                        tr (classes = "cv_edit_area__item") {
                           td { +"Конец обучения" }
                           td {
                              input { /*attrs.placeholder.plus("Год")*/ }
                           }
                        }
                     }
                     button (classes = "cv_edit_area__btn") {
                        /*attrs.style.plus("margin: 12px 0")*/
                        +"Добавить учебное заведение"
                     }
                  }
               }
               div(classes = "cv_nav") {
                  button (classes = "cvedit_btn") {
                     +"Назад"
                     attrs.onClickFunction = {
                        saveDate()
                        gotoPageCandidateEdit(pageId-1)
                     }
                  }
                  button (classes = "cvedit_btn") {
                     +"Далее"
                     attrs.onClickFunction = {
                        saveDate()
                        gotoPageCandidateEdit(pageId+1)
                     }
                  }
               }
            }
        }
    }

   private fun saveDate() {

   }
}

fun RBuilder.candidateEditEdu() = child(CandidateEditEdu::class) {

}
