package com.tree.www.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 914. 卡牌分组
 * <p>
 * Created by pysh on 2020-03-27.
 */
public class HasGroupsSizeX {

    public static void main(String[] args) {
        System.out.println(new HasGroupsSizeX().hasGroupsSizeX(new int[]{1, 2, 3, 4, 4, 3, 2, 1}));
        System.out.println(new HasGroupsSizeX().hasGroupsSizeX(new int[]{1, 1, 1, 2, 2, 2, 3, 3}));
        System.out.println(new HasGroupsSizeX().hasGroupsSizeX(new int[]{1}));
        System.out.println(new HasGroupsSizeX().hasGroupsSizeX(new int[]{1, 1}));
        System.out.println(new HasGroupsSizeX().hasGroupsSizeX(new int[]{1, 1, 2, 2, 2, 2}));
        System.out.println(new HasGroupsSizeX().hasGroupsSizeX(new int[]{1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3}));
    }

    /**
     * 给定一副牌，每张牌上都写着一个整数。
     * <p>
     * 此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：
     * <p>
     * 每组都有 X 张牌。
     * 组内所有的牌上都写着相同的整数。
     * <p>
     * 仅当你可选的 X >= 2 时返回 true。
     *
     * @param deck
     * @return
     */
    public boolean hasGroupsSizeX(int[] deck) {
        int length = deck.length;
        if (length <= 1) return false;
        Arrays.sort(deck);
        int count = 1, result = 0;
        for (int i = 1; i < length; i++) {
            if (deck[i] == deck[i - 1]) {
                count++;
            } else {
                if (count == 1) {
                    return false;
                } else {
                    if (result == 0) {
                        result = count;
                    } else {
                        result = gcd(count, result);
                    }
                    count = 1;
                }
            }
        }
        if (count == 1) return false;
        return gcd(result, count) >= 2;
    }

    /**
     * 求x,y的最大公约数
     *
     * @param x
     * @param y
     * @return
     */
    public int gcd(int x, int y) {
        int temp;
        while (y != 0) {
            temp = y;
            y = x % y;
            x = temp;
        }
        return x;
    }
}
