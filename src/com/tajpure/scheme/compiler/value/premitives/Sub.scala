package com.tajpure.scheme.compiler.value.premitives

import com.tajpure.scheme.compiler.value.PrimFunc
import com.tajpure.scheme.compiler.value.Value
import com.tajpure.scheme.compiler.ast.Node
import com.tajpure.scheme.compiler.value.IntValue
import com.tajpure.scheme.compiler.value.FloatValue
import com.tajpure.scheme.compiler.util.Log
import com.tajpure.scheme.compiler.exception.CompilerException

class Sub extends PrimFunc("-", -1) {

  def apply(args: List[Value], location: Node): Value = {
    if (args.size == 0) {
      throw new CompilerException("Exception: incorrect arguments count in call '-'", location)
    } 
    else if (args.size == 1) {
      if (args(0).isInstanceOf[IntValue]) {
         new IntValue( - args(0).asInstanceOf[IntValue].value)
      }
      else if (args(0).isInstanceOf[FloatValue]) {
         new FloatValue( - args(0).asInstanceOf[FloatValue].value)
      }
      else {
         Log.error(location, "Exception: incorrect arguments count in call '-'")
         Value.VOID
      }
    } 
    else {
      args.foldLeft(new IntValue(0).asInstanceOf[Value])((result, arg) => {
        if (result.isInstanceOf[IntValue] && arg.isInstanceOf[IntValue]) {
          new IntValue(result.asInstanceOf[IntValue].value - arg.asInstanceOf[IntValue].value)
        } 
        else if (result.isInstanceOf[IntValue] && arg.isInstanceOf[FloatValue]) {
          new FloatValue(result.asInstanceOf[IntValue].value - arg.asInstanceOf[FloatValue].value)
        } 
        else if (result.isInstanceOf[FloatValue] && arg.isInstanceOf[IntValue]) {
          new FloatValue(result.asInstanceOf[FloatValue].value - arg.asInstanceOf[IntValue].value)
        } 
        else if (result.isInstanceOf[FloatValue] && arg.isInstanceOf[FloatValue]) {
          new FloatValue(result.asInstanceOf[FloatValue].value - arg.asInstanceOf[FloatValue].value)
        } 
        else {
          Log.error(location, "Exception: incorrect arguments in call '-'")
          Value.VOID
        }
      })
    }
  }
  
  def codegen(args: List[Value], location: Node): Value = {
    null
  }

  def typecheck(args: List[Value], location: Node): Value = {
    null
  }

  override def toString: String = {
    "-"
  }

}