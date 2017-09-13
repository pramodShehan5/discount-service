package com.pagero.services.db.dao

import com.googlecode.flyway.core.Flyway
import com.pagero.services.calculator.DbConf
import com.pagero.services.db.model.{Item, Items}
import slick.driver.PostgresDriver.api._

import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}

object ItemsDAO extends TableQuery(new Items(_)) with DbConf {

  //val db = Database.forURL("jdbc:postgresql://172.17.0.1:5422/postgres?user=postgres&password=12345",
  // driver="org.postgresql.Driver")
  //  db.createSession().database
//  def findById(id: Long): Future[Option[Item]] = {
//    db.run(this.filter(_.id === id).result).map(_.headOption)
//  }

  def addItem(account: Item): Future[Item] = {
    db.run(this returning this.map(_.id) into ((acc, id) => acc.copy(id = id)) += account)
  }

  def deleteById(id: Long): Future[Int] = {
    db.run(this.filter(_.id === id).delete)
  }

  def updateById(id: Long,price:Long): Future[Int] = {
    val q = for { c <- this if c.id === id } yield c.price
    val updateAction = q.update(price)
    db.run(updateAction)
  }


}

object MainTest {
  def main(args: Array[String]): Unit = {
    //val db = Database.forURL("jdbc:postgresql://172.17.0.1:54362/postgres?user=postgres&password=12345",
    // driver="org.postgresql.Driver")

    //println(db)
//    val f:Future[Item] = AccountsDAO.create(Item(6, "xfghxf",2,3,4))
    //val f:Future[Option[Item]]  = ItemsDAO.findById(1)
    //val f:Future[Int]  = ItemsDAO.updateById(1,25)
    //val f:Future[Int]  = ItemsDAO.deleteById(1)
    val f:Future[Item]  = ItemsDAO.addItem(Item(1,"Beer",12,700,25))
    val item=Await.result(f, Duration.Inf)
    println(item)
  }
}

