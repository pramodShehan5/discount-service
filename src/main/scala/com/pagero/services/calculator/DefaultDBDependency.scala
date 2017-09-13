package com.pagero.services.calculator

trait DefaultDBDependency extends DBDependency {
  override val userDetailDAO = new DefaultUserDetailDAO
}
