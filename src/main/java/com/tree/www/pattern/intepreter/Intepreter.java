package com.tree.www.pattern.intepreter;

/**
 * 解释器模式
 * <p>
 * 评估语言的语法或表达式的方式，它属于行为型模式。
 * 这种模式实现了一个表达式接口，该接口解释一个特定的上下文。这种模式被用在 SQL 解析、符号处理引擎等
 * <p>
 * Created by pysh on 2018/6/1.
 */
public class Intepreter {

    public static void main(String[] args) {
        Expression isMale = IntepreterPatternDemo.getMaleExpression();
        Expression isMarriedWoman = IntepreterPatternDemo.getMarriedWomanExpression();
        String data1 = "John is male? ";
        String data2 = "Julie is a married women? ";
        System.out.println(data1 + isMale.interpret(data1));
        System.out.println(data2 + isMarriedWoman.interpret(data2));
    }
}

class IntepreterPatternDemo {
    // 规则：Robert 和 John 是男性
    public static Expression getMaleExpression() {
        Expression robert = new TerminalExpression("Robert");
        Expression john = new TerminalExpression("John");
        return new OrExpression(robert, john);
    }

    //规则：Julie 是一个已婚的女性
    public static Expression getMarriedWomanExpression() {
        Expression julie = new TerminalExpression("Julie");
        Expression married = new TerminalExpression("married");
        return new AndExpression(julie, married);
    }
}

interface Expression {
    boolean interpret(String context);
}

class TerminalExpression implements Expression {
    private String data;

    public TerminalExpression(String data) {
        this.data = data;
    }

    @Override
    public boolean interpret(String context) {
        return context.contains(data);
    }
}

class OrExpression implements Expression {

    private Expression expression1;
    private Expression expression2;

    public OrExpression(Expression expression1, Expression expression2) {
        this.expression1 = expression1;
        this.expression2 = expression2;
    }

    @Override
    public boolean interpret(String context) {
        return expression1.interpret(context) || expression2.interpret(context);
    }
}


class AndExpression implements Expression {

    private Expression expression1;
    private Expression expression2;

    public AndExpression(Expression expression1, Expression expression2) {
        this.expression1 = expression1;
        this.expression2 = expression2;
    }

    @Override
    public boolean interpret(String context) {
        return expression1.interpret(context) && expression2.interpret(context);
    }
}
