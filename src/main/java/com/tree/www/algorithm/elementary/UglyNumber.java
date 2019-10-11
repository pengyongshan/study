package com.tree.www.algorithm.elementary;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 丑数
 *
 * <p> 只含有2，3，5因子的数
 * Created by pysh on 2019-10-11.
 */
public class UglyNumber {

    public static void main(String[] args) {
        System.out.println("第1000个丑数是:" + getUglyNumberByIndex(1000));
    }

    private static long getUglyNumberByIndex(int index) {
        long result = 0L;
        if (index == 1) {
            return 1L;
        }
        Deque<Long> q2 = new ArrayDeque<>(), q3 = new ArrayDeque<>(), q5 = new ArrayDeque<>();
        q2.add(2L);
        q3.add(3L);
        q5.add(5L);
        while (--index > 0 && q2.size() != 0 && q3.size() != 0 && q5.size() != 0) {
            result = Math.min(Math.min(q2.peek(), q3.peek()), q5.peek());
            if (result == q2.peek()) {
                q2.pop();
                q2.add(result * 2);
                q3.add(result * 3);
                q5.add(result * 5);
            } else if (result == q3.peek()) {
                q3.pop();
                q3.add(result * 3);
                q5.add(result * 5);
            } else {
                q5.pop();
                q5.add(result * 5);
            }
        }
        System.out.println(q2);
        System.out.println(q3);
        System.out.println(q5);
        return result;
    }
}
