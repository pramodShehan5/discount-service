package com.pagero.services.calculator

trait DefaultDBDependency extends DBDependency {
  override val userDetail = new DefaultUserDetailDAO
}
