package com.tree.www.cache;

import java.util.Arrays;

// 测试
public class CachePoolTest {
    public static void main(String[] args) {
        CachePool c1 = CachePool.valueOf("1");
        CachePool c2 = CachePool.valueOf("2");
        CachePool c3 = CachePool.valueOf("9");
        CachePool c4 = CachePool.valueOf("2");
        CachePool.valueOf("3");
        CachePool.valueOf("8");
        CachePool.valueOf("4");
        CachePool.valueOf("5");
        CachePool.valueOf("6");
        CachePool.valueOf("7");
        CachePool.valueOf("11");
        CachePool.valueOf("12");
        
        System.out.println(c2 == c4);
    }
}

// 缓存池
class CachePool {
    private static final int MAX_SIZE = 10;
    private static CachePool[] pool = new CachePool[MAX_SIZE];

    private static int pos = 0; // 游标
    private final String name;

    private CachePool(String name) {
        this.name = name;   
    }

    public String getName() {
        return name;
    }
    public static CachePool valueOf(String name) {
        for (CachePool cache : pool) {
            if(cache != null && cache.name.equals(name)) {
                return cache;
            }
        }
        if(pos == MAX_SIZE) {
            pool[0] = new CachePool(name);
            pos = 1;
        } else {
            // 等价于赋值pool[pos]后，pos后移1
            pool[pos++] = new CachePool(name);
        }
        System.out.println(Arrays.toString(pool));
        return pool[pos-1];
    }

    @Override
    public String toString() {
    	return name;
    }
}
