import org.specs2.mutable._

class GameSpec extends Specification {
    "Newly-created Game" should {
        "have no rolls" in {
            new Game().rolls mustEqual Seq[Int]();
        }

        "have score of zero" in {
            new Game().score mustEqual 0;
        }
    }

    
}
