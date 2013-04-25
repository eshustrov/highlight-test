package highlight_test

case class SomeCaseClass(value: String, value2: String)

case class SomeOtherCaseClass(value: SomeCaseClass)

trait ToString {
  def toString(values: Any*) = getClass.getSimpleName + "(" + values.mkString(",") + ")"
}

class SomeClass(value: String, value2: String) extends ToString {
  override def toString = toString(value, value2)
}

class SomeOtherClass(value: SomeClass) extends ToString {
  override def toString = toString(value)
}

object HighlightTest {
  def main(args: Array[String]) {
    println(SomeOtherCaseClass(SomeCaseClass("highlight", "test")))
    println(new SomeOtherClass(new SomeClass("highlight", "test")))
  }
}
