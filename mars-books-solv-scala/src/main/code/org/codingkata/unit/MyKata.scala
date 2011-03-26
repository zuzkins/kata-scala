package org.codingkata.unit;

import _root_.org.codingkata.unit.api.BaseKataSolution;

class MyKata extends BaseKataSolution {
    val multiplicators = List(1, 3, 1, 3, 1, 3, 1, 3, 1, 3, 1, 3)
    
    def calcCheckDigit(isbn: String): Int = {
      def nums = isbn.map(_.toString.toInt)

      val products = (nums.zip(multiplicators)).map{case (num, mult) => num * mult}

      return 10 - (products.sum % 10) 
    }
}
