//package com.pagero.services.controller
//
//import com.pagero.services.calculator.DbConf
//import com.pagero.services.db.model.Item
////import db.model.{Item, Items}
////import slick.dbio.DBIO
////import slick.lifted.TableQuery
//////import proile.api._
////
////import scala.slick.driver.PostgresDriver.simple._
////import scala.concurrent.Future
//import scala.concurrent.Future
//import scala.concurrent.ExecutionContext.Implicits.global
//import slick.driver.PostgresDriver.api._
//
//object ItemsController extends DbConf {
////  extends TableQuery(new Items(_)) with DbConf {
//  def calculateTax(item: Item): Double = {
//    item.price * (item.tax / 100)
//  }
//
//  def calculatePrice(item: Item): Double = {
//    (item.price + calculateTax(item)) * item.quantity
//  }
//
////  def insertItems(item: Item): Unit = {
////    Database.forURL(url, driver = dbDriver) withSession {
////      implicit session =>
////        val items = TableQuery[Items]
////
////        val q = items.map(i => (i.name, i.tax, i.price, i.quantity))
////          .insert(("Wine", 10.0, 100.0, 80))
////
////        println("Item added successfully!")
////    }
////  }
////
// // def getItems() = {
//
////    Database.forURL(url, driver = dbDriver) withSession {
////      implicit session =>
////        val items = TableQuery[Items]
////
////        val q = items.list foreach { row =>
////          println(row + " item")
////        }
////    }
// // }
//
////  def insert():Future[Long] ={
////
////    val itemTable = TableQuery[Items]
////  //  val items = Seq[(String,Int)](("",2))
////
//////    (items returning items).in
////
//////    val insertActions = itemTable.map(i=> (i.name,i.quantity)) ++= Seq[(String,Int)](("",2))
//////    val insertActions2 = itemTable.map(i=> (i.name,i.quantity)) += ("",2)
//////    val tem2 = itemTable += ("",2)
//////    val insertActions = DBIO.seq(
//////  itemTable.map(i=> (i.name,i.quantity) += ("",2))
//////    )
//////tem2
////  //  val dd = db.run(tem2)
////  }
//
//
//}
