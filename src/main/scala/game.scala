class Game(pRolls: Seq[Int]) {
  val rolls = pRolls;

  def roll(pins: Int) : Game = {
    new Game(rolls :+ pins);
  }

  def this() = this(Seq[Int]());

  def score = 0;
}
