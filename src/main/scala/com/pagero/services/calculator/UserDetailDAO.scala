package com.pagero.services.calculator

import scala.concurrent.Future

trait UserDetailDAO {
  def checkUserDetail(customerId : Long): Option[UserDetail]
  def updateUserDetail(customerId : Long,price : Double , noTransaction : Int): Future[Int]
  def addUserDetail(userdetails : UserDetail): Future[UserDetail]
}
