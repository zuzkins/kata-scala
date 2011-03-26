package org.codingkata.unit;

import _root_.org.codingkata.unit.api.BaseKataSolution;
import scala.collection.muttable._

class MyKata extends BaseKataSolution {

  def isHappy(number: Long): Boolean {
    isHappy(number, Set.empty[Long])
  }

  def isHappy(num: Long, tried: Set[Long]) : Boolean = {
    if (tried.contains(num)) return false
    if (num == 1) return true
    tried += num
    return isHappy(num.toString.map(_.toDigit).foldLeft(0).(_ * _).sum, tried)
  }


}
