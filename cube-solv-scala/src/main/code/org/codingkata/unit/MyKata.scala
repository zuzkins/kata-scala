package org.codingkata.unit;

import _root_.org.codingkata.unit.api.BaseKataSolution;

class MyKata extends BaseKataSolution {

    def containsPrimeNumber(code1 : String, code2 : String, code3 : String) : Boolean = {
	    isPrime(sum(code1)) || isPrime (sum(code2)) || isPrime(sum(code3))
    }

	def isPrime(value : Int) : Boolean = {
		(2 to value-1) forall(value % _ != 0)
	}

	def sum(numbers : String) : Int = {
		val nums = numbers.toList.map(x => x.toString.toInt)
		sum(nums)
	}
	def sum(nums : List[Int]) : Int = nums match {
		case Nil => 0
		case head::tail => head + sum(tail)
	}
}