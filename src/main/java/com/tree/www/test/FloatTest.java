package com.tree.www.test;

/**
 * Created by pysh on 2019-05-16.
 */
public class FloatTest {
    public static void main(String[] args) {
        float a = 1.0f - 0.9f;
        float b = 0.9f - 0.8f;

        System.out.println(Float.floatToIntBits(a));

        System.out.println(a == b);

        Float m = Float.valueOf(a);
        Float n = Float.valueOf(b);
        System.out.println(m.equals(n));

        Double x = new Double(a);
        Double y = new Double(b);
        System.out.println(x.equals(y));
    }
}
