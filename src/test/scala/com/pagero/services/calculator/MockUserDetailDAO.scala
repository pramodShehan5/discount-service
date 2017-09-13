package com.pagero.services.calculator

import scala.concurrent._
import ExecutionContext.Implicits.global

class MockUserDetailDAO(userDetail: UserDetail) extends UserDetailDAO {
  override def checkUserDetail(id : Long): Option[UserDetail] = {
    Option(userDetail)
  }

  override def updateUserDetail(customerId : Long,price : Double , noTransaction : Int): Future[Int] = {
    Future(userDetail.noTransactions)
  }

  override def addUserDetail(userdetails: UserDetail): Future[UserDetail] = {
    Future(userDetail)
  }
}
