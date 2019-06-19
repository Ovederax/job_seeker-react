package comp.account.candidate.cv

import comp.account.gotoPageAccount
import kotlinx.html.js.onClickFunction
import kotlinx.html.style
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.button
import react.dom.div
import react.dom.img
import react.dom.input

interface CandidateEditOtherProps : RProps {

}

interface CandidateEditOtherState : RState {

}



class CandidateEditOther(props: CandidateEditOtherProps) : RComponent<CandidateEditOtherProps, CandidateEditOtherState>(props) {
   var socials = arrayOf(
           "content/social/odnoklassniki.png",
           "content/social/vk.png",
           "content/social/instagram.png",
           "content/social/twitter2.png",
           "content/social/facebook2.png"
   )
   override fun RBuilder.render() {
        div (classes = "intro") {
            div(classes = "container") {
               candidateEditCV(4, "Дополнительно")

               div(classes = "cv_edit_area") {
                  div(classes = "cv_edit_area_inner") {
                     div(classes = "cvedit_other__photo") {
                        div(classes = "other__edit_photo") {
                           img(src = "content/cvedit/photo.png") {  }
                           div { +"Загрузить фото" }
                        }
                        div (classes = "other__edit_photo_desc") {
                           div(classes = "fwbold") {
                              +"Личная фотография"
                           }
                           +("Загрузите одну личную фотографию, где нет посторонних людей и животных. " +
                            "Лицо на фото должно быть в фокусе полностью: от линии волос и до нижней точки подбородка, также должны быть видны уши.")
                        }
                     }
                  }
               }

               div(classes = "fwbold") {
                  +"Профиль в социальной сети"
               }
               div() {
                  +"Укажите ссылки на профили в социальных сетях (это поможет нам лучше узнать Вши предпочтения и посоветовать подходяющую работу)."
               }
               div(classes = "cv_other_social") {
                  socials.forEach {
                     div(classes = "cv_other_social__item") {
                        img(src = it) {  }
                        input {  }
                     }
                  }

               }
               div(classes = "cv_nav") {
                  div {  }
                  button(classes = "cvedit_btn") {
                     +"Сохранить"
                     attrs.onClickFunction = {
                        saveDate()
                        gotoPageAccount()
                     }
                  }
               }
            }
        }
    }

   private fun saveDate() {

   }
}

fun RBuilder.candidateEditOther() = child(CandidateEditOther::class) {

}
