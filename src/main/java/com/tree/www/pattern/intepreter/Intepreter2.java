package com.tree.www.pattern.intepreter;

import java.util.HashMap;
import java.util.Map;

/**
 * 以手机编辑铃声为例：
 * 首先制定规则，S代表速度，500低速，1000中速，1500高速，
 * O代表音阶，‘O 1’代表低音阶,‘O 2’代表中音阶，‘O 3’代表高音阶，
 * ‘P’代表休止符，‘CDEFGAB’代表音调，1表示一拍，0.5表示半拍，依此类推。所有的字母和数字使用空格分隔
 * <p>
 * Created by pysh on 2018/6/1.
 */
public class Intepreter2 {
    public static void main(String[] args) {
        Conetxt conetxt = new Conetxt();
        conetxt.setPlayText("S 1500 O 2 E 0.5 G 0.5 A 3 E 0.5 G 0.5 D 3 E 0.5 " +
                "G 0.5 A 0.5 O 3 C 1 O 2 A 0.5 G 1 C 0.5 E 0.5 D 3 ");
        AbstractExpression expression;
        while (conetxt.getPlayText().length() > 0) {
            expression = ExpressionFactory.createExpression(conetxt.getPlayText());
            expression.interpret(conetxt);
        }
    }
}

// 演奏内容类
class Conetxt {
    private String playText;

    public String getPlayText() {
        return playText;
    }

    public void setPlayText(String playText) {
        this.playText = playText;
    }
}

// 表达式类
abstract class AbstractExpression {
    //将演奏文本解析为对应的key和value，根据key值指定解释器
    public void interpret(Conetxt conetxt) {
        if (conetxt.getPlayText().length() == 0) {
            return;
        }
        //获取文本第一个字符作为key值
        String playText = conetxt.getPlayText();
        String key = playText.substring(0, 1);
        //获取key值后截取文本
        playText = playText.substring(2);
        //获取截取后文本第一个字段作为value值
        Double value = Double.parseDouble(playText.substring(0, playText.indexOf(" ")));
        //获取value值后截取文本
        playText = playText.substring(playText.indexOf(" ") + 1);
        conetxt.setPlayText(playText);
        excute(key, value);
    }

    protected abstract void excute(String key, Double value);
}

// 音符类
class NoteExpression extends AbstractExpression {

    @Override
    protected void excute(String key, Double value) {
        String note = "";
        switch (key) {
            case "C":
                note = "1";
                break;
            case "D":
                note = "2";
                break;
            case "E":
                note = "3";
                break;
            case "F":
                note = "4";
                break;
            case "G":
                note = "5";
                break;
            case "A":
                note = "6";
                break;
            case "B":
                note = "7";
                break;
        }
        System.out.print(note + " ");
    }
}

// 音调类
class ScaleExpression extends AbstractExpression {

    @Override
    protected void excute(String key, Double value) {
        String scale = "";
        switch (value.intValue()) {
            case 1:
                scale = "low";
                break;
            case 2:
                scale = "middle";
                break;
            case 3:
                scale = "high";
                break;
        }
        System.out.print(scale + " ");
    }
}

// 音速类
class SpeedExpression extends AbstractExpression {

    @Override
    protected void excute(String key, Double value) {
        String speed = "";
        switch (value.intValue()) {
            case 500:
                speed = "slow";
                break;
            case 1000:
                speed = "middle";
                break;
            case 1500:
                speed = "fast";
                break;
        }
        System.out.print(speed + " ");
    }
}

// 享元模式来生成各种具体的解释器
class ExpressionFactory {
    private static Map<String, AbstractExpression> expressionMap = new HashMap<>();

    public static AbstractExpression createExpression(String text) {
        String key = text.substring(0, 1);
        AbstractExpression expression = null;
        switch (key) {
            case "C":
            case "D":
            case "E":
            case "F":
            case "G":
            case "A":
            case "B":
                expression = expressionMap.computeIfAbsent("note", k -> new NoteExpression());
                break;
            case "O":
                expression = expressionMap.computeIfAbsent("scale", k -> new ScaleExpression());
                break;
            case "S":
                expression = expressionMap.computeIfAbsent("speed", k -> new SpeedExpression());
                break;
        }
        return expression;
    }
}

