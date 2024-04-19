package com.tree.www.cache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by pysh on 2020/12/19.
 */
public class LRUCacheTest<K, V> extends LinkedHashMap<K, V> {
    private static final long serialVersionUID = 8148853763203724677L;
    private int max;
    private static final int DEFAULT_CAPACITY = 100;

    public LRUCacheTest(){
        super(16, 0.75f, true);
        this.max = DEFAULT_CAPACITY;
    }

    public LRUCacheTest(int max) {
        super(16, 0.75f, true);
        this.max = max;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > max;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public static void main(String[] args) {
        LRUCacheTest<Integer, Integer> lru = new LRUCacheTest<>();
        for (int i = 0; i < 200; i++) {
            lru.get(i-50);
            lru.put(i,i);
        }
        for (Integer value : lru.values()) {
            System.out.print(value + ",");
        }
    }
}
