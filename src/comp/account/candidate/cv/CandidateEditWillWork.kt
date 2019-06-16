package comp.account.candidate.cv

import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.div


interface CandidateEditWillWorkProps : RProps {

}

interface CandidateEditWillWorkState : RState {

}
class CandidateEditWillWork(props: CandidateEditWillWorkProps) : RComponent<CandidateEditWillWorkProps, CandidateEditWillWorkState>(props) {
    override fun RBuilder.render() {
        div {
            +"Lending"
        }
    }
}

fun RBuilder.candidateEditWillWork() = child(CandidateEditWillWork::class) {

}