package comp.account

import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.div


/** Страница /account/ для Соискателя*/

interface UserAccountMainProps : RProps {

}

interface UserAccountMainState : RState {

}

class UserAccountMain(props: UserAccountMainProps) : RComponent<UserAccountMainProps, UserAccountMainState>(props) {
    override fun RBuilder.render() {
        div {
            +"user account"
        }
    }
}

fun RBuilder.userAccount() = child(UserAccountMain::class) {

}
