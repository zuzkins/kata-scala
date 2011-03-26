package org.codingkata.unit;

import _root_.org.codingkata.unit.api.BaseKataSolution;

class MyKata extends BaseKataSolution {

    def revert(text : String) : String = {
	    //text.reverse
	    new String(text.toList.reverse.toArray) //woohoo!
    }
}