package com.tajpure.scheme.compiler.value.premitives

import org.jllvm._type.FunctionType
import org.jllvm._type.Type

import com.tajpure.scheme.compiler.Scope
import com.tajpure.scheme.compiler.ast.Node
import com.tajpure.scheme.compiler.value.PrimFunc
import com.tajpure.scheme.compiler.value.Value
import org.jllvm.value.user.constant.Function

class Display extends PrimFunc("display" , -1) {
  
  def apply(args: List[Value], location: Node): Value = {
    args.foreach { arg => print(arg) }
    Value.VOID
  }
  
  def typecheck(args: List[Value], location: Node): Value= {
    null
  }
  
  def codegen(args: List[org.jllvm.value.Value], location: Node, s: Scope): org.jllvm.value.Value = {
    val _params: Array[Type] = args.map { arg => s.codegen.any }.toArray
    val printf: Function = new Function(s.codegen.module, "anonymous", new FunctionType(s.codegen.any, _params, false))
    null
  }

  override
  def toString: String = {
    "display"
  }
  
}