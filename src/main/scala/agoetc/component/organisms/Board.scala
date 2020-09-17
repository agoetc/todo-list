package agoetc.component.organisms

import agoetc.component.atoms.Todo
import slinky.core.FunctionalComponent
import slinky.core.annotations.react
import slinky.core.facade.ReactElement
import slinky.web.html._

@react object Board {

  type Props = Unit

  val component: FunctionalComponent[Props] = FunctionalComponent[Props] { _ =>
    div()(
      (1 to 5).map(_ => renderTodo)
    )
  }


  def renderTodo: ReactElement = Todo()
}