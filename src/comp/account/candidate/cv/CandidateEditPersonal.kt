package comp.account.candidate.cv

import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.div

interface CandidateEditPersonalProps : RProps {

}

interface CandidateEditPersonalState : RState {

}

class CandidateEditPersonal(props: CandidateEditPersonalProps) : RComponent<CandidateEditPersonalProps, CandidateEditPersonalState>(props) {
    override fun RBuilder.render() {
        div {
            +"Lending"
        }
    }
}

fun RBuilder.candidateEditPersonal() = child(CandidateEditPersonal::class) {

}