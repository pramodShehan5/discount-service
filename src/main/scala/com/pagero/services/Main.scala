package com.pagero.services

import com.pagero.services.calculator.{DefaultDBDependency, DiscountCalculator}
import com.pagero.services.discounting.spec.DiscountingSpec


object Main extends DiscountingService  {

  lazy override val discountingServer = createServer(DiscountingSpec)

  lazy override val calculator = new DiscountCalculator with DefaultDBDependency {}

  override def init(): Unit = {
    //    BootstrapDatabase.update()
  }
}