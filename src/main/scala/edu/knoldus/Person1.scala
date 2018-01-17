package edu.knoldus

import org.apache.log4j.Logger

abstract class Person1 {
  def isWinner(num: Int): String = {

    val r = scala.util.Random
    val digit = Constants.ONE + r.nextInt(Constants.SIX)
    digit match {
      case 1 | 6 => if (num == 0) "Winner" else isWinner(num - 1)
      case _ => "Looser"

    }
  }

  def showPerson(person: Person1): String = {
    /* def generateRandom(num:Int):Int= {
       val r = scala.util.Random
       1 + r.nextInt(6)
     }*/
    person match {

      case Trainer() => {

        val strength = scala.util.Random
        s"Total Attendance =${strength.nextInt(Constants.FIFTYONE)}"

      }
      case Gamer(count: Int) => {

        isWinner(count)

      }
    }
  }

  case class Trainer() extends Person1

  case class Gamer(num: Int) extends Person1

}


object UsingPerson extends Person1 with App {

  val log = Logger.getLogger(this.getClass)
  val totalAttendance = showPerson(Trainer())
  log.info(s"$totalAttendance")
  val count = 0
  val result = showPerson(Gamer(count))
  log.info(s"Result $result")

}
