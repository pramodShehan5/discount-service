package com.pagero.services.calculator

import scala.concurrent.Future

trait UserDetailDAO {
  def checkUserDetail(customerId : Long): Future[Option[UserDetail]]
  def updateUserDetail(customerId : Long,price : Double): Future[Int]
  def addUserDetail(userdetails : UserDetail): Future[UserDetail]
}
