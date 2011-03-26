package org.codingkata.unit;

import _root_.org.codingkata.unit.api.BaseKataSolution;

class MyKata extends BaseKataSolution {

	def calcGCD(val1 : Int, val2 : Int) : Int = if (val2 == 0) val1 else calcGCD(val2, val1 % val2)

}