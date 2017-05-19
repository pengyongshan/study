package com.tree.www.pattern.intepreter;

import java.util.Stack;

import org.omg.CORBA.Context;

/**
 * 解释器模式---项目中很少用到 效率低（递归） 难维护（类多 逻辑复杂）
 * 
 * 
 * 通常Client是一个封装类，封装的结果就是传递进来一个规范语法文件，
 * 
 * 解析器分析后产生结果并返回， 避免了调用者与语法解析器的耦合关系。
 * 
 * @author pys
 *
 * @date 2016年4月22日 上午10:04:43
 */
public class Client {

	public static void main(String[] args) {


		Context ctx;
		
		// 进行语法判断，并产生递归调用
		Stack<Expression> stack = new Stack<Expression>();

		stack.push(new TerminalExpression());
		for (;;) {
			// 进行语法处理，并产生递归调用
			break;
		}

		// 产生一个完整的语法树，由各各个具体的语法分析进行解析
		TerminalExpression exp = new TerminalExpression();

		// 具体进入应用场景
		// exp.interpreter(ctx);
	}

}
