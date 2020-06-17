package com.tree.www.leetcode;

/**
 * 等式方程的可满足性
 * <p>
 * Created by pysh on 2020-06-12.
 */
public class Leetcode990 {

    /**
     * 给定一个由表示变量之间关系的字符串方程组成的数组，每个字符串方程 equations[i] 的长度为 4，
     * 并采用两种不同的形式之一："a==b" 或 "a!=b"。在这里，a 和 b 是小写字母（不一定不同），表示单字母变量名。
     * <p>
     * 只有当可以将整数分配给变量名，以便满足所有给定的方程时才返回 true，否则返回 false。 
     * tips:
     * 1 <= equations.length <= 500
     * equations[i].length == 4
     * equations[i][0] 和 equations[i][3] 是小写字母
     * equations[i][1] 要么是 '='，要么是 '!'
     * equations[i][2] 是 '='
     */
    public boolean equationsPossible(String[] equations) {
        int flag = 1;
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }
        for (String equation : equations) {
            if (equation.charAt(1) == '=') {
                int index1 = equation.charAt(0) - 'a';
                int index2 = equation.charAt(3) - 'a';
                if (a[index1] == 0 && a[index2] == 0) {
                    a[index1] = a[index2] = flag++;
                } else if (a[index1] == 0 || a[index2] == 0) {
                    a[index1] = a[index2] = Math.max(a[index1], a[index2]);
                } else {
                    int x = a[index1], y = a[index2], temp = Math.max(x, y);
                    for (int i = 0; i < a.length; i++) {
                        if (a[i] == x || a[i] == y) {
                            a[i] = temp;
                        }
                    }
                }
            }
        }

        for (String equation : equations) {
            if (equation.charAt(1) == '!') {
                int index1 = equation.charAt(0) - 'a';
                int index2 = equation.charAt(3) - 'a';
                if (a[index1] != 0 && a[index2] != 0 && a[index1] == a[index2]) {
                    return false;
                }
            }
        }
        return true;
    }


    // 并查集
    int[] a = new int[26];

    public boolean equationsPossible2(String[] equations) {
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }
        for (String equation : equations) {
            if (equation.charAt(1) == '=') {
                int index1 = equation.charAt(0) - 'a';
                int index2 = equation.charAt(3) - 'a';
                merge(index1, index2);
            }
        }

        for (String equation : equations) {
            if (equation.charAt(1) == '!') {
                int index1 = equation.charAt(0) - 'a';
                int index2 = equation.charAt(3) - 'a';
                if (findRoot(index1) == findRoot(index2)) {
                    return false;
                }
            }
        }
        return true;
    }

    private void merge(int x, int y) {
        a[findRoot(x)] = findRoot(y);
    }

    private int findRoot(int x) {
        //父节点设为根节点, 压缩路径
        return x == a[x] ? x : (a[x] = findRoot(a[x]));
    }

    public static void main(String[] args) {
        String[] a = {"a==z", "a==b", "b==c", "c==d", "b==y", "c==x", "d==w", "g==h", "h==i", "i==j", "a==g", "j!=y"};
        System.out.println(new Leetcode990().equationsPossible2(a));
    }
}
