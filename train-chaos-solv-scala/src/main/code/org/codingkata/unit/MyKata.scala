package org.codingkata.unit;

import _root_.org.codingkata.unit.api.BaseKataSolution;

class MyKata extends BaseKataSolution {
  var stack: List[Integer] = Nil

  def push(car: Integer): Unit = {
    stack = car :: stack
  }

  def pop(): Integer = {
    if (stack.isEmpty) return -1

    val ret = stack.head
    stack = stack match {
      case Nil => Nil
      case _   => stack.tail
    }
    
    ret
  }
  
  def peek(): Integer = {
    stack match {
      case Nil => -1
      case _   => stack.head
    }
  }
}

