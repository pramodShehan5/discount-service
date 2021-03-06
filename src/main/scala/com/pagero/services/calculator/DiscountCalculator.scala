package com.pagero.services.calculator

import scala.concurrent.Await
import scala.concurrent.duration.Duration

trait DiscountCalculator {
  this: DBDependency =>

  private val NONE_DISCOUNT = 0
  private val PRIMARY_DISCOUNT = 10
  private val SECONDARY_DISCOUNT = 15
  private val MAXIMUM_DISCOUNT = 25
  private val MINIMUM_DISOUNTABLE_TRANSACTIONS = 3
  private val MINIMUM_DISOUNTABLE_PRICE = 30000
  private val MAXIMUM_DISOUNTABLE_PRICE = 100000
  private val DISOUNTABLE_ITEM_PRICE = 50000

  def calculate(customerId: Long, items: List[Item]): DiscountResult = {
    val itemPrice = items.map(item => item.price).sum

    val userDetailOption = userDetailDAO.checkUserDetail(customerId)

    userDetailOption match {
      case Some(userDetail) =>
        Await.result(userDetailDAO.updateUserDetail(customerId,
          userDetail.price + itemPrice,
          userDetail.noTransactions + 1), Duration.Inf)
        calculate(userDetail, items)
      case None =>
        Await.result(userDetailDAO.addUserDetail(UserDetail(1, 1, itemPrice)), Duration.Inf)
        DiscountResult(None, List()) //save the transaction details
    }
  }

  def calculate(userDetail: UserDetail, items: List[Item]): DiscountResult = {
    if (userDetail.noTransactions <= MINIMUM_DISOUNTABLE_TRANSACTIONS) {

      DiscountResult(Option(NONE_DISCOUNT))
    } else {
      if (userDetail.price <= MINIMUM_DISOUNTABLE_PRICE) {

        DiscountResult(Option(PRIMARY_DISCOUNT))
      } else if (userDetail.price > MINIMUM_DISOUNTABLE_PRICE &&
        userDetail.price <= MAXIMUM_DISOUNTABLE_PRICE) {

        DiscountResult(Option(SECONDARY_DISCOUNT))
      } else {

        DiscountResult(None, calculateItemDiscounts(items))
      }
    }
  }

  private def calculateItemDiscounts(items: List[Item]): List[ItemWiseDiscount] = {

    items.map(item =>
      ItemWiseDiscount(item.id,
        if (item.price >= DISOUNTABLE_ITEM_PRICE) {
          MAXIMUM_DISCOUNT
        } else {
          SECONDARY_DISCOUNT
        }))
  }

}