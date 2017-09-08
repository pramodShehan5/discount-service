package com.pagero.services.calculator

import slick.driver.PostgresDriver.api._

case class Item(id: Long, name: String, price: Double)

case class UserDetail(id: Long, noTransactions: Int, price: Double)

class UserDetails(tag: Tag) extends Table[UserDetail](tag, "userdetails") {
  def id = column[Long]("id", O.PrimaryKey, O.AutoInc)

  def time = column[Int]("time")

  def price = column[Double]("price")

  def * = (id, time, price) <> (UserDetail.tupled, UserDetail.unapply)
}

case class ItemWiseDiscount(id: Long, discount: Double)

case class DiscountResult(generalDiscount: Option[Double], itemDiscounts: List[ItemWiseDiscount] = List())
