package com.tree.www.pattern.intepreter;

import org.omg.CORBA.Context;

// 抽象表达式
public abstract class Expression {

	/**
	 * 每个表达式必须有一个解析任务
	 * 
	 * @param ctx--环境角色
	 * @return
	 */
	public abstract Object interpreter(Context ctx);

}
