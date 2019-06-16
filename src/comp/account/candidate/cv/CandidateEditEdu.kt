package comp.account.candidate.cv

import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.div

interface CandidateEditEduProps : RProps {

}

interface CandidateEditEduState : RState {

}

class CandidateEditEdu(props: CandidateEditEduProps) : RComponent<CandidateEditEduProps, CandidateEditEduState>(props) {
    override fun RBuilder.render() {
        div {
            +"Lending"
        }
    }
}

fun RBuilder.candidateEditEdu() = child(CandidateEditEdu::class) {

}
