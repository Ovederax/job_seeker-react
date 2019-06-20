package comp.account.candidate.cv

import dto.CandidateEducationRequest
import kotlinx.html.js.onClickFunction
import kotlinx.html.style
import org.w3c.dom.HTMLInputElement
import org.w3c.dom.HTMLSelectElement
import org.w3c.dom.get
import react.*
import react.dom.*
import rest.ServerAPI
import kotlin.browser.window

interface CandidateEditEduProps : RProps {

}

interface CandidateEditEduState : RState {
   var educationLevel:String
   var city:String
   var instituteName:String
   var instituteDepartment:String
   var profession:String
   var educationalForm:String
   var startDate:String
   var endDate:String
}

class CandidateEditEdu(props: CandidateEditEduProps) : RComponent<CandidateEditEduProps, CandidateEditEduState>(props) {
   var refs:dynamic = null
   val pageId = 1;
   enum class FieldNames(val field: String) {
      EducationLevel("educationLevel"),
      State("city"),
      Institute("instituteName"),
      Faculty("instituteDepartment"),
      Specialty("profession"),
      TrainingForm("educationalForm"),
      BeginDate("startDate"),
      EndDate("endDate")
   }

   override fun componentWillMount() {
      state.educationLevel = ""
      state.city = ""
      state.instituteName = ""
      state.instituteDepartment = ""
      state.profession = ""
      state.educationalForm = ""
      state.startDate = ""
      state.endDate = ""

      ServerAPI().getEducation {
         val edu: CandidateEducationRequest = JSON.parse(it)
         state.educationLevel = edu.educationLevel ?: ""
         state.city = edu.city ?: ""
         state.instituteName = edu.instituteName ?: ""
         state.instituteDepartment = edu.instituteDepartment ?: ""
         state.profession = edu.profession ?: ""
         state.educationalForm = edu.educationalForm ?: ""
         state.startDate = edu.startDate ?: ""
         state.endDate = edu.endDate ?: ""
         setState() {

         }
      }
   }

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
                                 attrs["ref"] = FieldNames.EducationLevel.field
                                 option() {+"Высшее"}
                              }
                           }
                        }

                        tr (classes = "cv_edit_area__item") {
                           td { +"Город" }
                           td {
                              input {
                                 attrs["value"] = state.city
                                 attrs["ref"] = FieldNames.State.field
                              }
                           }
                        }
                        tr (classes = "cv_edit_area__item") {
                           td { +"Учебное заведение" }
                           td {
                              input {
                                 attrs["value"] = state.instituteName
                                 attrs["ref"] = FieldNames.Institute.field
                              }
                           }
                        }

                        tr (classes = "cv_edit_area__item") {
                           td { +"Факультет" }
                           td {
                              attrs["value"] = state.instituteDepartment
                              input { attrs["ref"] = FieldNames.Faculty.field }
                           }
                        }

                        tr (classes = "cv_edit_area__item") {
                           td { +"Специальность" }
                           td {
                              attrs["value"] = state.profession
                              input { attrs["ref"] = FieldNames.Specialty.field }
                           }
                        }

                        tr (classes = "cv_edit_area__item") {
                           td { +"Форма обучения" }
                           td {
                              select () {
                                 attrs["ref"] = FieldNames.TrainingForm.field
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
                                 attrs["value"] = state.startDate
                                 attrs["ref"] = FieldNames.BeginDate.field
                                 attrs["placeholder"] = "Год"
                              }
                           }
                        }

                        tr (classes = "cv_edit_area__item") {
                           td { +"Конец обучения" }
                           td {
                              input {
                                 attrs["value"] = state.endDate
                                 attrs["ref"] = FieldNames.EndDate.field
                                 attrs["placeholder"] = "Год"
                              }
                           }
                        }
                     }
                     button (classes = "cv_edit_area__btn") {
                        //attrs["style"] = "margin: 12px 0"
                        +"Добавить учебное заведение"
                     }
                  }
               }
               div(classes = "cv_nav") {
                  button (classes = "cvedit_btn") {
                     +"Назад"
                     attrs.onClickFunction = {
//                        saveDate() {
//                           gotoPageCandidateEdit(pageId - 1)
//                        }
                     }
                  }
                  button (classes = "cvedit_btn") {
                     +"Далее"
                     attrs.onClickFunction = {
//                        saveDate() {
//                           gotoPageCandidateEdit(pageId+1)
//                        }
                     }
                  }
               }
            }
        }
    }

   fun saveDate(func: ()->Unit) {
      val educationLevel      = (findDOMNode(refs[FieldNames.EducationLevel.field]) as HTMLSelectElement).value
      val city                = (findDOMNode(refs[FieldNames.State.field])          as HTMLInputElement).value
      val instituteName       = (findDOMNode(refs[FieldNames.Institute.field])      as HTMLInputElement).value
      val instituteDepartment = (findDOMNode(refs[FieldNames.Faculty.field])        as HTMLInputElement).value
      val profession          = (findDOMNode(refs[FieldNames.Specialty.field])      as HTMLInputElement).value
      val educationalForm     = (findDOMNode(refs[FieldNames.TrainingForm.field])   as HTMLSelectElement).value
      val startDate           = (findDOMNode(refs[FieldNames.BeginDate.field])      as HTMLInputElement).value
      val endDate             = (findDOMNode(refs[FieldNames.EndDate.field])        as HTMLInputElement).value

      ServerAPI().updateEducation(JSON.stringify(CandidateEducationRequest(
           educationLevel, city, instituteName, instituteDepartment, profession, educationalForm, startDate, endDate
      ))) {
         func()
      }
   }
}

fun RBuilder.candidateEditEdu() = child(CandidateEditEdu::class) {

}
