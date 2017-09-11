package com.pagero.services.db.model

import slick.driver.PostgresDriver.api._

case class Invoice( id:Int , listItems:List[Item])

class Invoices(tag: Tag) extends Table[( Int,String,Int)](tag, "invoices") {
  def id = column[Int]("id", O.PrimaryKey)
  def name = column[String]("name")
  def price = column[Int]("price")

  def * = (id, name, price)
}
