package com.tree.www.pattern.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * 围棋
 * <p>
 * Created by pysh on 2018/6/1.
 */
public class Flyweight3 {
    public static void main(String[] args) {
        IgoChessman b1, b2, b3, b4, w1, w2;
        IgoChessmanFactory factory = IgoChessmanFactory.getInstance();

        b1 = factory.getIgoChessman("b");
        b2 = factory.getIgoChessman("b");
        b3 = factory.getIgoChessman("b");
        b4 = factory.getIgoChessman("b");
        w1 = factory.getIgoChessman("w");
        w2 = factory.getIgoChessman("w");
        System.out.println("判断两颗黑子是否相同：" + (b1 == b2));
        System.out.println("判断两颗白子是否相同：" + (w1 == w2));
        b1.display(new Coordinates(1,2));
        b2.display(new Coordinates(3,4));
        b3.display(new Coordinates(5,6));
        b4.display(new Coordinates(7,8));
        w1.display(new Coordinates(2,2));
        w2.display(new Coordinates(4,2));
    }
}


abstract class IgoChessman {
    public abstract String getColor();

    public void display(Coordinates coordinates) {
        System.out.println("棋子颜色：" + getColor() + ", 棋子位置：" + coordinates);
    }
}

class BlackIgoChessman extends IgoChessman {

    @Override
    public String getColor() {
        return "黑色";
    }
}

class WhiteIgoChessman extends IgoChessman {

    @Override
    public String getColor() {
        return "白色";
    }
}

class IgoChessmanFactory {

    private static IgoChessmanFactory instance = new IgoChessmanFactory();

    private static Map<String, IgoChessman> IGO_CHESSMAN_POOL;

    public IgoChessmanFactory() {
        IGO_CHESSMAN_POOL = new HashMap<>();
        IGO_CHESSMAN_POOL.put("b", new BlackIgoChessman());
        IGO_CHESSMAN_POOL.put("w", new WhiteIgoChessman());
    }

    public static IgoChessmanFactory getInstance() {
        return instance;
    }

    public IgoChessman getIgoChessman(String color) {
        return IGO_CHESSMAN_POOL.get(color);
    }
}

class Coordinates {
    private int x, y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "("+ x + ", " + y + ")";
    }
}
