package com.pagero.services.calculator

import slick.driver.PostgresDriver.api._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}
import scala.util.{Failure, Success, Try}

class DefaultUserDetailDAO extends TableQuery(new UserDetails(_)) with DbConf with UserDetailDAO {
  override def checkUserDetail(userid: Long): Option[UserDetail] = {
    val dbTry = Try[Option[UserDetail]] {
      Await.result(db.run(this.filter(_.id === userid).result).map(_.headOption), Duration.Inf)
    }
    dbTry match {
      case Success(result) =>
        result
      case Failure(e) =>
        e.printStackTrace()
        None
    }
  }

  override def updateUserDetail(customerId: Long, price: Double,noTransaction : Int) = {
    val updateAction = this.filter(_.id === customerId).map(user => (user.price,user.time)).
      update((price,noTransaction))
    db.run(updateAction)
  }

  override def addUserDetail(userdetails: UserDetail) = {
    db.run(this returning this.map(_.id) into ((acc, id) => acc.copy(id = id)) += userdetails)
  }

}
