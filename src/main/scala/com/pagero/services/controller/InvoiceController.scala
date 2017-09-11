//
//package com.pagero.services.controller
//
//
//object InvoiceController {
//  def getTotalOfInvoice(invoiceObj: Invoice): Double = {
//    val listPrice = for (item <- invoiceObj.listItems) yield ItemsController.calculatePrice(item)
//    //(item.price * item.quantity) + (item.price*(item.tax/100))
//    listPrice.sum
//  }
//
//  def getTotal(listInvoice: List[Invoice]): Double = {
//    val listItems = for (invoice <- listInvoice) yield getTotalOfInvoice(invoice)
//    listItems.sum
//  }
//}
//
