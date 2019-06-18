package comp.account.candidate.cv

import kotlinx.html.classes
import kotlinx.html.js.onClickFunction
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.div
import kotlin.browser.window

interface CandidateEditCVProps : RProps {
	var path: String;
	var activeId: Int
}

interface CandidateEditCVState : RState {

}

// <div id="content"  class="cvedit-background">
//<header class="header">
//   <div class="header__inner">
//      <div class="header__logo">
//         <img class="logo__img" src="content/icons/logo.png" alt="">
//         <div class="logo__text">JOB SEEKER</div>
//      </div>
//
//      <nav class="nav">
//         <a class="nav__link" href="#">Поиск работы</a>
//         <a class="nav__link" href="#">Новая вакансия</a>
//         <a class="nav__link" href="#">Компании</a>
//         <a class="nav__auth" href="#">
//            <img src="content/icons/exit.png" alt="">
//         </a>
//      </nav>
//   </div>
//</header>

class CandidateEditCV(props: CandidateEditCVProps) : RComponent<CandidateEditCVProps, CandidateEditCVState>(props) {
	var header = arrayOf("Персональные данные",	"Образование", "Опыт работы", "Желаемая должность", "Дополнительно")
	var paths = arrayOf("/account/personal", "/account/education", "/account/work_exp", "/account/will_work", "/account/other")

	override fun RBuilder.render() {
        div (classes = "path") {
            +(props.path)
        }
		div(classes = "cvedit__title") {
			+"Редактировать резюме"
		}

		div(classes = "cv_menu") {
			for(id in 0 until header.size) {
				var cl = "cv_menu__item";
				if(id == props.activeId) {
					cl = "cv_menu__item cv_menu__item--active"
				}
				div(classes = cl) {

					div {
						+header[id]
					}
					attrs.onClickFunction = {
						window.location.href = "#"+paths[id]
					}
				}
			}
		}

    }
}

fun RBuilder.candidateEditCV(id: Int, path:String) = child(CandidateEditCV::class) {
	attrs.path = "Главная / Личный кабинет / $path"
	this.attrs.activeId = id;
}
