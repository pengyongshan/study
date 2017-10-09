package com.tree.www.collection;

import java.util.TreeSet;

public class TreeSetTest {
    /***
     * TreeSet中的元素是有序的.
     *
     * 默认自然排序即比较对象的compareTo方法,TreeSet元素必须实现Comparable接口.
     *
     * TreeSet元素应该属于同一个对象.
     *
     * TreeSet compareTo返回0 元素相等无法加入
     *
     */
    public static void main(String[] args) throws Exception {
        // 定制排序
        TreeSet<R> set = new TreeSet((o1, o2) -> ((R) o1).count > ((R) o2).count ? 1 : (((R) o1).count == ((R) o2).count ? 0 : -1));
        set.add(new R(5));
        set.add(new R(10));
        set.add(new R(-2));
        set.add(new R(-9));
        System.out.println(set);

        System.out.println(set.first());
        System.out.println(set.last());
        System.out.println(set.headSet(new R(4))); // 小于4的子集
        System.out.println(set.tailSet(new R(5))); // 大于等于5
        System.out.println(set.subSet(new R(-3), new R(4))); // -3 <=x < 4

        R last = (R) set.last();
        last.count = -2;
        R first = (R) set.first();
        first.count = -2;
        System.out.println(set);
        System.out.println(set.remove(new R(-2)));
        System.out.println(set);
        System.out.println(set.remove(new R(-2)));
        System.out.println(set.remove(new R(-2)));
        System.out.println(set.remove(new R(5)));
        System.out.println(set);
    }
}

class R {

    int count;

    public R(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return String.valueOf(count);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && obj.getClass() == R.class) {
            R r = (R) obj;
            return r.count == this.count;
        }
        return false;
    }

}
