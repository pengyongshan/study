package com.tree.www.test;

/**
 * 扑克牌小游戏
 * <p>
 * Created by pysh on 2018/3/15.
 */
public class PKTest {
    public static void main(String[] args) {
        int temp = 13;
        for (int i = 1, j = 1; i <= temp; i++, j++) {
            temp += 1;
            System.out.println(i + "->" + temp);
            i++;
            System.out.println(i + "=" + j);
        }
    }
}
