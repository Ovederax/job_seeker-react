package comp.account.candidate.cv

import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.div


interface CandidateEditWorkExpProps : RProps {

}

interface CandidateEditWorkExpState : RState {

}


class CandidateEditWorkExp(props: CandidateEditWorkExpProps) : RComponent<CandidateEditWorkExpProps, CandidateEditWorkExpState>(props) {
    override fun RBuilder.render() {
        div {
            +"Lending"
        }
    }
}

fun RBuilder.candidateEditWorkExp() = child(CandidateEditWorkExp::class) {

}
