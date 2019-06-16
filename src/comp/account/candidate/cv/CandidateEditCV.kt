package comp.account.candidate.cv

import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.div

interface CandidateEditCVProps : RProps {

}

interface CandidateEditCVState : RState {

}

class CandidateEditCV(props: CandidateEditCVProps) : RComponent<CandidateEditCVProps, CandidateEditCVState>(props) {
    override fun RBuilder.render() {
        div {
            +"Lending"
        }
    }
}

fun RBuilder.candidateEditCV() = child(CandidateEditCV::class) {

}
