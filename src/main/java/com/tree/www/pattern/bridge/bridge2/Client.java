package com.tree.www.pattern.bridge.bridge2;


/**
 * 模板方法和桥梁模式结合
 *
 * Created by pysh on 2018/3/20.
 */
public class Client {
    public static void main(String[] args) {
        AbstractMaobi maobi = new BigMaobi(new Green());
        maobi.paint();

        maobi = new LittleMaobi(new Red());
        maobi.paint();
    }
}

abstract class AbstractMaobi {
    protected AbstractColor color;

    public AbstractMaobi(AbstractColor color) {
        this.color = color;
    }

    public final void paint() {
        choose();
        color();
        huahua();
    }

    public abstract void choose();
    public void color() {
        color.color();
    }
    public  void huahua() {
        System.out.println("画画");
    }
}

class BigMaobi extends AbstractMaobi {

    public BigMaobi(AbstractColor color) {
        super(color);
    }

    @Override
    public void choose() {
        System.out.println("选择大号毛笔");
    }

}

class Maobi extends AbstractMaobi {

    public Maobi(AbstractColor color) {
        super(color);
    }

    @Override
    public void choose() {
        System.out.println("中号毛笔");
    }
}

class LittleMaobi extends AbstractMaobi {

    public LittleMaobi(AbstractColor color) {
        super(color);
    }

    @Override
    public void choose() {
        System.out.println("选择小号毛笔");
    }
}

abstract class AbstractColor {
    abstract void color();
}
class Green extends AbstractColor {

    @Override
    void color() {
        System.out.println("这是绿色");
    }
}

class Red extends AbstractColor {

    @Override
    void color() {
        System.out.println("这是红色");
    }
}
