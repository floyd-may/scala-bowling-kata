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

  "Gutter Game" should {
    val gutterGame = Iterator
      .continually(0)
      .take(20)
      .foldLeft(new Game()){ (game, roll) => game.roll(roll) };
    "have twenty rolls of zero" in {
      gutterGame.rolls mustEqual (Iterator.continually(0).take(20) toSeq);
    }

    "have score of zero" in {
      gutterGame.score mustEqual 0;
    }
  }
}
