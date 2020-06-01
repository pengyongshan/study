package com.tree.www.leetcode;

/**
 * Created by pysh on 2020-05-21.
 */
public class Leetcode50 {

    public double myPow(double x, long n) {
        // Math.pow(x, n);
        if (n < 0) {
            return 1.0 / myPow(x, -n);
        } else {
            double result = 1.0, initValue = x;
            while (n != 0) {
                if (n % 2 == 1) {
                    result *= initValue;
                }
                initValue *= initValue;
                n /= 2;
            }
            return result;
        }
    }
}
