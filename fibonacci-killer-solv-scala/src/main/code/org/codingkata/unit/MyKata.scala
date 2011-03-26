package org.codingkata.unit;

import _root_.org.codingkata.unit.api.BaseKataSolution;

class MyKata extends BaseKataSolution {

    def fibonacci(i : Int) : Int = i match {
	    case 0 => 0
	    case 1 => 1
	    case _ => fibonacci(i - 1) + fibonacci(i - 2)
    }
}