package com.tree.www.pattern.intepreter;

import org.omg.CORBA.Context;

// 非终结符表达式
public class NoterminalExpression extends Expression {

	// 每个非终结符表达式都会对其他表达式产生依赖
	public NoterminalExpression(Expression... expressions) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object interpreter(Context ctx) {
		// 进行文法处理
		return null;
	}


}
