class Game(pClosedFrames: Seq[Frame], pOpenFrame: Frame) {
  val closedFrames = pClosedFrames;
  val openFrame = pOpenFrame;

  def this() = this(Seq[Frame](), EmptyFrame());

  def roll(pins: Int) = if(closedFrames.length < 9) {
      openFrame match {
        case _: EmptyFrame => appendNewFrame(pins)
        case f: OpenFrame => 
          new Game(
            closedFrames :+ createClosedFrame(f.roll, pins),
            EmptyFrame())
      }
    }
    else {
      openFrame match {
        case _: EmptyFrame => appendNewFrame(pins)
        case f: OpenFrame => 
          new Game(
            closedFrames,
            createClosedFrame(f.roll, pins))
        case f: SpareFrame =>
          new Game(
            closedFrames,
            FinalFrame(f.firstRoll, f.secondRoll, pins))
      }
    }

  private def createClosedFrame(firstRoll: Int, secondRoll: Int) = 
    if(firstRoll + secondRoll == 10)
      SpareFrame(firstRoll, secondRoll)
    else
      ClosedFrame(firstRoll, secondRoll)

  private def appendNewFrame(pins: Int) = 
    if(pins == 10)
      new Game(closedFrames :+ StrikeFrame(), EmptyFrame())
    else
      new Game(closedFrames, OpenFrame(pins))
}

abstract class Frame;
case class EmptyFrame() extends Frame;
case class StrikeFrame() extends Frame;
case class OpenFrame(roll: Int) extends Frame;
case class ClosedFrame(firstRoll: Int, secondRoll: Int) extends Frame;
case class SpareFrame(firstRoll: Int, secondRoll: Int) extends Frame;
case class FinalFrame(
  firstRoll: Int,
  secondRoll: Int,
  bonusRoll: Int) extends Frame;

