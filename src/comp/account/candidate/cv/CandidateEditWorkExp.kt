package comp.account.candidate.cv

import dto.CandidateWorkExpRequest
import kotlinx.html.InputType
import kotlinx.html.js.onClickFunction
import kotlinx.html.style
import org.w3c.dom.HTMLAreaElement
import org.w3c.dom.HTMLInputElement
import org.w3c.dom.HTMLSelectElement
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.*
import rest.ServerAPI


interface CandidateEditWorkExpProps : RProps {

}

interface CandidateEditWorkExpState : RState {

}




class CandidateEditWorkExp(props: CandidateEditWorkExpProps) : RComponent<CandidateEditWorkExpProps, CandidateEditWorkExpState>(props) {
   var refs:dynamic = null
   private val pageId = 2

   enum class FieldNames(val field: String) {
      Company("companyName"),
      Position("position"),
      City("city"),

      StartDate("startDate"),
      StartDateMonth("startDateMonth"),
      StartDateYear("startDateYear"),

      EndDate("endDate"),
      EndDateMonth("endDateMonth"),
      EndDateYear("endDateYear"),

      WorkStatus("workStatus"),
      Additional("additional")
   }

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
                      val fieldNamesList = arrayOf(FieldNames.Company.field, FieldNames.Position.field, FieldNames.City.field)

                      for(iter in 0..2) {
                         tr (classes ="cv_edit_area__item") {
                            td {
                               +namesList[iter]
                               span (classes = "col_red") { +"*" }
                            }
                            td { input {
                               attrs["ref"] = fieldNamesList[iter]
                               attrs["placeholder"] = placeholderList[iter]
                              }
                            }
                         }
                      }

                      tr (classes ="cv_edit_area__item") {
                         td { +"Начало работы" }
                         td {
                            input(classes = "width_10percent margin_right_5px"){
                               attrs["ref"] = FieldNames.StartDateMonth.field
                               attrs["placeholder"] = "Месяц"
                            }
                            input(classes = "width_14percent"){
                               attrs["ref"] = FieldNames.StartDateYear.field
                               attrs["placeholder"] = "Год"
                            }
                         }
                      }
                      tr (classes ="cv_edit_area__item") {
                         td { +"Конец работы" }
                         td {
                            input(classes = "width_10percent margin_right_5px") {
                               attrs["ref"] = FieldNames.EndDateMonth.field
                                 attrs["placeholder"] = "Месяц"
                            }
                            input(classes = "width_14percent"){
                               attrs["ref"] = FieldNames.EndDateYear.field
                               attrs["placeholder"] = "Год"
                            }
                         }
                      }
                      tr (classes ="cv_edit_area__item") {
                         td {  }
                         td {
                            input (classes = "wh16px", type = InputType.checkBox) { attrs["ref"] = FieldNames.WorkStatus.field }
                            +"Работаю на данный момент"
                         }
                      }

                   }
                   div {
                      //attrs["style"] = "margin: 18px 7px 0"
                      +"Обязанности и достижения"
                      span (classes = "col_red") { +"*" }
                   }

                   div(classes = "flex_row_container") {
                      div {
                         textArea(rows = "8", cols = "64") {
                            attrs["ref"] = FieldNames.Additional.field
                            //attrs["style"] = "font-size: 16px;";
                            attrs["placeholder"] = "Введите описание..."
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
                      saveDate() {
                         gotoPageCandidateEdit(pageId-1)
                      }

                   }
                   +"Назад"
                }
                button (classes = "cvedit_btn") {
                   attrs.onClickFunction = {
                      saveDate() {
                         gotoPageCandidateEdit(pageId+1)
                      }
                   }
                   +"Далее"
                }
             }
          }
       }

    }

   private fun saveDate(func: ()->Unit) {
      val companyName   : String?  = (findDOMNode(refs[FieldNames.Company.field]) as HTMLInputElement).value
      val position      : String?  = (findDOMNode(refs[FieldNames.Position.field]) as HTMLInputElement).value
      val city          : String?  = (findDOMNode(refs[FieldNames.City.field]) as HTMLInputElement).value
      val startDate     : String?  = (findDOMNode(refs[FieldNames.StartDateYear.field]) as HTMLInputElement).value
      val endDate       : String?  = (findDOMNode(refs[FieldNames.EndDateYear.field]) as HTMLInputElement).value
      val workStatus    : Boolean? = (findDOMNode(refs[FieldNames.WorkStatus.field]) as HTMLInputElement).checked
      val additional    : String?  = (findDOMNode(refs[FieldNames.Additional.field]) as HTMLAreaElement).textContent

      ServerAPI().updateEducation(JSON.stringify(CandidateWorkExpRequest(
              companyName,  position, city, startDate, endDate, workStatus, additional
      ))) {
         func()
      }


   }
}

fun RBuilder.candidateEditWorkExp() = child(CandidateEditWorkExp::class) {

}
