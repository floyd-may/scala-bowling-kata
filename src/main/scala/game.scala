class Game(pRolls: Seq[Frame]) {
  val rolls = pRolls;

  def roll(pins: Int) : Game = {
    new Game(rolls :+ pins);
  }

  def this() = this(Seq[Int]());

  def score = rolls.sum;
}

abstract class Frame;
case class OpenFrame(roll: Int) extends Frame;
case class ClosedFrame(firstRoll: Int, secondRoll: Int) extends Frame;
