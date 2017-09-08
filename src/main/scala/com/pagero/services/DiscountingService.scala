package com.pagero.services

import com.pagero.service.ServiceApplication
import com.pagero.servicecomm.ServiceServer
import com.pagero.services.calculator.{DiscountCalculator, Item}
import com.pagero.services.discounting.DiscountingServiceInfo
import com.pagero.services.discounting.spec.{CalculateDiscountMessage, CalculateDiscountReply, ItemDiscount}

import scala.concurrent.Future

trait DiscountingService extends ServiceApplication with DiscountingServiceInfo {

  import scala.concurrent.ExecutionContext.Implicits.global

  def discountingServer: ServiceServer

  def calculator: DiscountCalculator

  discountingServer addMessageHandler {
    implicit ctx => {
      case msg: CalculateDiscountMessage =>
        val result = calculator.calculate(msg.userid.get,msg.items.map(item => Item(item.id.get, item.name.get, item.price.get)).toList)

        println(result.toString)

        Future(CalculateDiscountReply(result.generalDiscount,
          result.itemDiscounts.map(resultItem => ItemDiscount(Option(resultItem.id), Option(resultItem.discount)))))
    }
  }
}