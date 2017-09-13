package com.pagero.services.calculator

trait MockDBDependency extends DBDependency {
  override val userDetailDAO = new MockUserDetailDAO(UserDetail(1,2,2000000))
}