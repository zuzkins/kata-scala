package org.codingkata.unit;

import _root_.org.codingkata.unit.api.BaseKataSolution;

class MyKata extends BaseKataSolution {

    def translate(text : String, strings : Array[Array[String]]) : String = {
	    translate(text, strings.toList)
    }

	def translate(text : String, dictionary : List[Array[String]]) : String = dictionary match {
		case Nil => text
		case head::tail => translate(text.replaceAll("\\$" + head(0) + "\\$", head(1)), tail)
	}
}