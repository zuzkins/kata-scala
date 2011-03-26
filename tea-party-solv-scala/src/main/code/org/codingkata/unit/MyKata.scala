package org.codingkata.unit;

import _root_.org.codingkata.unit.api.BaseKataSolution;

class MyKata extends BaseKataSolution {

	def welcome (lastName : String, isWoman : Boolean, isSir : Boolean) : String =  {
		"Hello " + personTitle(isWoman, isSir) + " " + lastName
	}

	def personTitle(isWoman: Boolean, isSir: Boolean) : String = (isWoman, isSir) match {
		case (_, true) => "Sir"
		case (true, _) => "Ms."
		case (_, _) => "Mr."
	}

}