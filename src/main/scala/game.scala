class Game(pClosedFrames: Seq[Frame], pOpenFrame: Frame) {
  val closedFrames = pClosedFrames;
  val openFrame = pOpenFrame;

  def this() = this(Seq[Frame](), EmptyFrame());

  def roll(pins: Int) = openFrame match {
    case _: EmptyFrame => new Game(closedFrames, OpenFrame(pins))
    case f: OpenFrame => 
      new Game(
        closedFrames :+ createClosedFrame(f.roll, pins),
        EmptyFrame())
  }

  private def createClosedFrame(firstRoll: Int, secondRoll: Int) = 
    if(firstRoll + secondRoll == 10)
      SpareFrame(firstRoll, secondRoll)
    else
      ClosedFrame(firstRoll, secondRoll)
}

abstract class Frame;
case class EmptyFrame() extends Frame;
case class OpenFrame(roll: Int) extends Frame;
case class ClosedFrame(firstRoll: Int, secondRoll: Int) extends Frame;
case class SpareFrame(firstRoll: Int, secondRoll: Int) extends Frame;
