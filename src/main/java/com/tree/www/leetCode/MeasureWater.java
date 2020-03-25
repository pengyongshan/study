package com.tree.www.leetCode;

/**
 * 365. 水壶问题
 * <p>
 * Created by pysh on 2020-03-25.
 */
public class MeasureWater {

    public static void main(String[] args) {
        System.out.println(gcd(1, 5));
        System.out.println(gcd(5, 3));
        System.out.println(gcd(6, 2));
        System.out.println(gcd(2, 6));
    }

    /**
     * 有两个容量分别为 x升 和 y升 的水壶以及无限多的水。请判断能否通过使用这两个水壶，从而可以得到恰好 z升 的水？
     * <p>
     * 如果可以，最后请用以上水壶中的一或两个来盛放取得的 z升 水。
     * <p>
     * 你允许：
     * <p>
     * 装满任意一个水壶
     * 清空任意一个水壶
     * 从一个水壶向另外一个水壶倒水，直到装满或者倒空.
     * <p>
     * z = ax + by && z <= x + y
     *
     * @param x
     * @param y
     * @param z
     * @return
     */
    public boolean canMeasureWater(int x, int y, int z) {
        if (x + y < z) return false;
        if (x == z || y == z || x + y == z) return true;

        return z % gcd(x, y) == 0;
    }

    /**
     * 求x,y的最大公约数
     * @param x
     * @param y
     * @return
     */
    public static int gcd(int x, int y) {
        int temp;
        while(y != 0) {
            temp = y;
            y = x % y;
            x = temp;
        }
        return x;
    }
}
