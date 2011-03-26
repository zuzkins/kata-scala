package org.codingkata.unit;

import _root_.org.codingkata.unit.api.BaseKataSolution

class MyKata extends BaseKataSolution {

	def countdown(start : Int) : Array[Integer] = {
		appendInt(start).toArray
	}

	def appendInt(x : Int) : List[Integer] = x match {
		case 0 => List(x)
		case x => x :: appendInt(x - 1)
	}
}