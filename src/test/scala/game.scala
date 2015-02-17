import org.specs2.mutable._

class GameSpec extends Specification {
  "Newly-created Game" should {
    "have no closed frames" in {
      new Game().closedFrames mustEqual Seq[Frame]();
    }
    "have an empty open frame" in {
      new Game().openFrame mustEqual EmptyFrame();
    }
  }

  "Single-roll Game" should {
    "have openFrame with first roll" in {
      new Game().roll(4).openFrame mustEqual OpenFrame(4);
    }
  }

  "Two rolls" should {
    val game = new Game().roll(4).roll(3);

    "have a closed frame" in {
      game.closedFrames mustEqual Seq(ClosedFrame(4, 3));
    }
    "have an empty open frame" in {
      game.openFrame mustEqual EmptyFrame();
    }
  }

  "Seventeen rolls of 3" should {
    val rolls = Iterator.continually(3).take(17);
    val game = rolls.foldLeft(new Game())((g, p) => g.roll(p));
    val expectedFrames = Iterator.continually(ClosedFrame(3, 3)).take(8).toSeq
    "have eight closed frames" in {
      game.closedFrames mustEqual expectedFrames;
    }
    "have an open frame" in {
      game.openFrame mustEqual OpenFrame(3);
    }
  }

  "Spare with adjacent rolls that add to 10" should {
    val rolls = Seq(2, 4, 6, 3, 8, 2);
    val game = rolls.foldLeft(new Game())((g, p) => g.roll(p));
    val expectedFrames = Seq(
      ClosedFrame(2, 4),
      ClosedFrame(6, 3),
      SpareFrame(8, 2)
    );
    "have one SpareFrame" in {
      game.closedFrames mustEqual expectedFrames;
    }
    "have an empty open frame" in {
      game.openFrame mustEqual EmptyFrame();
    }
  }
}

