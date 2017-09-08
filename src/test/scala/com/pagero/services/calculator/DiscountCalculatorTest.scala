//package com.pagero.services.calculator
//
//import org.scalatest.FunSuite
//
//class DiscountCalculatorTest extends FunSuite {
//
//  private val MAXIMUM_DISOUNTABLE_TRANSACTIONS = 4
//  private val ITEM_LIST = List(Item(1, "Side mirrors", 40000), Item(2, "Tyres", 70000))
//
//  test("no discount if transaction count is less than three or equal to three") {
//
//    val calculator = new DiscountCalculator with MockDBDependency {}
//
//    val discount = calculator.calculate(ITEM_LIST)
//    assertDiscountCheck(discount, 0)
//  }
//
//  test("10% discount if transaction count is more than three and price is less than 30000") {
//    val calculator = new DiscountCalculator with MockDBDependency {
//      override val transactionDetail = new MockTransactionDetail(MAXIMUM_DISOUNTABLE_TRANSACTIONS, 20000)
//    }
//
//    val discount = calculator.calculate(ITEM_LIST)
//    assertDiscountCheck(discount, 10)
//  }
//
//  test("15% discount if transaction count is more than three and price is more than 30000") {
//    val calculator = new DiscountCalculator with MockDBDependency {
//      override val transactionDetail = new MockTransactionDetail(MAXIMUM_DISOUNTABLE_TRANSACTIONS, 35000)
//    }
//
//    val discount = calculator.calculate(ITEM_LIST)
//    assertDiscountCheck(discount, 15)
//  }
//
//  test("25% discount for each item if transaction count is more than three, total price is more than 100000 and item " +
//    "price is more than 50000") {
//    val calculator = new DiscountCalculator with MockDBDependency {
//
//      override val transactionDetail = new MockTransactionDetail(MAXIMUM_DISOUNTABLE_TRANSACTIONS, 150000)
//    }
//    val discount = calculator.calculate(ITEM_LIST)
//    assert(discount.generalDiscount.isEmpty)
//
//    discount.itemDiscounts.find(itemDiscount => itemDiscount.id == 2) match {
//      case Some(ItemWiseDiscount(_, disocuntResult)) =>
//        assert(disocuntResult == 25)
//      case None =>
//        fail("Should have an item discount")
//    }
//    discount.itemDiscounts.find(itemDiscount => itemDiscount.id == 1) match {
//      case Some(ItemWiseDiscount(_, disocuntResult)) =>
//        assert(disocuntResult == 15)
//      case None =>
//        fail("Should have an item discount")
//    }
//  }
//
//  test("15% discount for each item if transaction count is more than three,total price is more than 100000 and item " +
//    "price is less than 50000") {
//    val calculator = new DiscountCalculator with MockDBDependency {
//
//      override val transactionDetail = new MockTransactionDetail(MAXIMUM_DISOUNTABLE_TRANSACTIONS, 150000)
//    }
//
//    val discount = calculator.calculate(ITEM_LIST)
//
//    assert(discount.generalDiscount.isEmpty)
//    discount.itemDiscounts.find(itemDiscount => itemDiscount.id == 2) match {
//      case Some(ItemWiseDiscount(_, disocuntResult)) =>
//        assert(disocuntResult == 25)
//      case None =>
//        fail("Should have an item discount")
//    }
//    discount.itemDiscounts.find(itemDiscount => itemDiscount.id == 1) match {
//      case Some(ItemWiseDiscount(_, disocuntResult)) =>
//        assert(disocuntResult == 15)
//      case None =>
//        fail("Should have an item discount")
//    }
//  }
//
//  private def assertDiscountCheck(discount: DiscountResult, discountPrecentage: Double) = {
//    assert(discount.generalDiscount == Option(discountPrecentage))
//    assert(discount.itemDiscounts.isEmpty)
//  }
//}