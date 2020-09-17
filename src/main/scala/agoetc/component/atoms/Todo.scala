package agoetc.component.atoms

import slinky.core.FunctionalComponent
import slinky.core.annotations.react
import slinky.web.html._


@react object Todo {
  type Props = Unit

  val component: FunctionalComponent[Props] = FunctionalComponent[Props] { _ =>
    div(className := "todo")(
      p(className := "title")("title"),
      p(className := "description")("description"),
      p()("---------------")
    )
  }
}
