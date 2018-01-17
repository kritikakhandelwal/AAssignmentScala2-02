package edu.knoldus

import org.apache.log4j.Logger

abstract class Person {
  def isWinner(count: Int): String = {

    val r = scala.util.Random
    val randomDigit = Constants.ONE + r.nextInt(Constants.SIX)
    randomDigit match {
      case Constants.ONE | Constants.SIX => if (count == 0) "Winner" else isWinner((count + 1) - 1)
      case _ => "Looser"
    }
  }

  def showPerson(person: Person): String = {
    person match {

      case Gamer(count: Int) => {

        isWinner(count)

      }
      case Trainer() => {

        val strength = scala.util.Random
        s"Total Attendance =${strength.nextInt(Constants.FIFTYONE)}"

      }

    }
  }

  case class Trainer() extends Person

  case class Gamer(num: Int) extends Person

}


object UsingPerson extends Person with App {

  val log = Logger.getLogger(this.getClass)
  val totalAttendance = showPerson(Trainer())
  log.info(s"$totalAttendance   ")
  val count = 3
  if (count == 3) {
    val result = showPerson(Gamer(count))
    log.info(s"\n Result $result")
  }
}
