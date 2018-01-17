package edu.knoldus

import org.apache.log4j.Logger

abstract class PaymentMode {

  case class Paytm() extends PaymentMode

  case class Freecharge() extends PaymentMode

  case class NetBanking() extends PaymentMode

  case class CardPayment() extends PaymentMode

  case class Cash() extends PaymentMode
}

object Calculator extends PaymentMode with App {

  val log = Logger.getLogger(this.getClass)
  val amount = 20
  val payMethod = Paytm()
  //val totalAmount=print("Total Amount = "+ "Rs" + calculateAmount(amount,Paytm()))
  val totalAmount = log.info("Total Amount = Rs" + calculateAmount(amount, payMethod))

  def calculateAmount(amount: Int, payMethod: PaymentMode): Double = {
    payMethod match {
      case a: Paytm => (amount + (0.02 * amount))
      case b: Freecharge => (amount + (0.02 * amount))
      case c: NetBanking => (amount + 5)
      case d: CardPayment => (amount + 1.5)
      case e: Cash => (amount)
    }
  }
}



















