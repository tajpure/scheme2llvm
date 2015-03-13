package com.tajpure.scheme.compiler.ast

import com.tajpure.scheme.compiler.Scope
import com.tajpure.scheme.compiler.value.Value

class FloatNum(_content: String, _file: String, _start: Int, _end: Int, _row: Int, _col: Int)
  extends Node(_file, _start, _end, _row, _col) {
  
  val content: String = _content

  def interp(s: Scope): Value = {
    null
  }

  def typeCheck(s: Scope): Value = {
    null
  }
  
  override
  def toString(): String = {
    content
  }
}