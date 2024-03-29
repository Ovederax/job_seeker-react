package comp.account.candidate.cv

import kotlinx.html.js.onClickFunction
import kotlinx.html.style
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.*

interface CandidateEditPersonalProps : RProps {

}

interface CandidateEditPersonalState : RState {

}


class CandidateEditPersonal(props: CandidateEditPersonalProps) : RComponent<CandidateEditPersonalProps, CandidateEditPersonalState>(props) {
    var refs:dynamic = null
    private val pageId = 0

    enum class FieldNames(val field: String) {

    }

    override fun RBuilder.render() {
       div (classes = "intro") {
          div(classes = "container") {
             candidateEditCV(pageId, "Персональные данные")

             div(classes = "cv_edit_area cvedit_personal") {
                div(classes = "cvedit_personal__sup") { +"Персональные данные, поступившие с портала государственных услуг" }

                div(classes = "table_group") {
                   div(classes = "cvedit_personal__title") { +"Основная информация" }
                   table(classes = "cv_personal__table") {
                      tr() {
                         td(classes = "w45percent") {
//                            attrs.style = js {
//                               width = "45%
//                            }
                            +"ФИО"
                         }
                         td {  }
                      }
                      tr() {
                         td { +"Дата рождения" }
                         td {  }
                      }
                      tr() {
                         td { +"Удостоверение личности" }
                         td {  }
                      }
                   }
                }

                div(classes = "table_group") {
                   div(classes = "cvedit_personal__title") { +"Идентификаторы" }
                   table(classes = "cv_personal__table") {
                      tr() {
                         td (classes = "w45percent") { /*attrs.style { +"width:45%" }*/
                           +"СНИЛС"
                         }
                         td {  }
                      }
                      tr() {
                         td { +"ИНН" }
                         td {  }
                      }
                   }
                }

                div(classes = "table_group") {
                   div(classes = "cvedit_personal__title") { +"Контактная информация" }
                   table(classes = "cv_personal__table") {
                      tr() {
                         td (classes = "w45percent") { /*attrs.style { +"width:45%" }*/
                            +"Адрес регистрации"
                         }
                         td {  }
                      }
                      tr() {
                         td { +"Адрес временной регистрации" }
                         td {  }
                      }
                      tr() {
                         td { +"Адрес места жительства" }
                         td {  }
                      }
                      tr() {
                         td { +"Контактный телефон" }
                         td {  }
                      }
                      tr() {
                         td { +"Адрес электронной почты" }
                         td {  }
                      }
                   }
                }

             }

             div(classes = "cv_nav") {
                div {  }
                button(classes = "cvedit_btn") {
                    +"Далее"
                    attrs.onClickFunction = {
                        gotoPageCandidateEdit(pageId+1)
                    }
                }
             }
          }
       }
    }
}

fun RBuilder.candidateEditPersonal() = child(CandidateEditPersonal::class) {

}