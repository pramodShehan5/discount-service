package com.pagero.services.db.model

import slick.driver.PostgresDriver.api._

case class Item(id: Long, name: String,tax:Double,price:Double,quantity: Int)

class Items(tag: Tag) extends Table[Item](tag, "items") {
  def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
  def name = column[String]("name")
  def tax = column[Double]("tax")
  def price = column[Double]("price")
  def quantity = column[Int]("quantity")
  def * = (id, name,tax,price,quantity) <> (Item.tupled, Item.unapply)
}
