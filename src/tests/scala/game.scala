import org.specs2.mutable._

class GameSpec extends Specification {
    "Newly-created Game" should {
        "have no rolls" in {
            new Game().rolls must equal Seq(Int)[]
        }
    }
}
