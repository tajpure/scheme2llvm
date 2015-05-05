package com.tajpure.scheme.compiler.value

import com.tajpure.scheme.compiler.ast.Node
import com.tajpure.scheme.compiler.Scope

abstract class PrimFunc(_name: String, _arity: Int) extends Value {
  
  val name: String = _name
  
  // -1 stand for  n
  val arity: Int = _arity
  
  def apply(args: List[Value], location: Node): Value
  
  def apply(args: List[Value], location: Node, s: Scope): Value = {
    null
  }
  
  def typecheck(args: List[Value], location: Node): Value
  
  def codegen(args: List[org.jllvm.value.Value], location: Node, s: Scope): org.jllvm.value.Value
  
  override
  def toString(): String = {
    name
  }
  
}