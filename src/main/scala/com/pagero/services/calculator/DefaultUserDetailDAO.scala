package com.pagero.services.calculator

import slick.driver.PostgresDriver.api._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

class DefaultUserDetailDAO extends TableQuery(new UserDetails(_)) with DbConf with UserDetailDAO {
  override def checkUserDetail(userid: Long): Future[Option[UserDetail]] = {
    db.run(this.filter(_.id === userid).result).map(_.headOption)
  }

  override def updateUserDetail(customerId: Long, price: Double) = {
    val q = for {c <- this if c.id === customerId} yield c.price
    val updateAction = q.update(price)
    db.run(updateAction)
  }

  override def addUserDetail(userdetails: UserDetail) = {
    db.run(this returning this.map(_.id) into ((acc, id) => acc.copy(id = id)) += userdetails)
  }
}