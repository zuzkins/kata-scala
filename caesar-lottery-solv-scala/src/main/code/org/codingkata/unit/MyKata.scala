package org.codingkata.unit;

import _root_.org.codingkata.unit.api.BaseKataSolution;

class MyKata extends BaseKataSolution {

    def convert( i : Int) : String = {
	    convert(i/10, "C", "L", "X") + convert(i % 10, "X", "V", "I")
    }

	def convert(i : Int, top : String, middle : String, low : String) : String = i match {
		case 0 => ""
		case 9 => low + top
		case _ if i > 5 => middle + cloneString(i - 5, low)
		case 5 => middle
		case 4 => low + middle
		case _ => cloneString(i, low)
	}

	 def cloneString(times : Int, what : String) : String = if (times < 1) "" else what + cloneString (times - 1, what)
}