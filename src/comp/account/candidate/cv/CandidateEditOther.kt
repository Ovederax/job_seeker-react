package comp.account.candidate.cv

import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.div

interface CandidateEditOtherProps : RProps {

}

interface CandidateEditOtherState : RState {

}

class CandidateEditOther(props: CandidateEditOtherProps) : RComponent<CandidateEditOtherProps, CandidateEditOtherState>(props) {
    override fun RBuilder.render() {
        div {
            +"Lending"
        }
    }
}

fun RBuilder.candidateEditOther() = child(CandidateEditOther::class) {

}
