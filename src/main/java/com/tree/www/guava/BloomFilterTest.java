package com.tree.www.guava;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

/**
 * Created by pysh on 2019-11-14.
 */
public class BloomFilterTest {
    private static int FILTE_SIZE = 1000000;
    private static final BloomFilter<Integer> BLOOM_FILTER = BloomFilter.create(Funnels.integerFunnel(), FILTE_SIZE, 0.003);
    private static final BloomFilter<Integer> BLOOM_FILTER2 = BloomFilter.create(Funnels.integerFunnel(), FILTE_SIZE);

    public static void main(String[] args) {
        for (int i = 0; i < FILTE_SIZE; i++) {
            BLOOM_FILTER.put(i);
            BLOOM_FILTER2.put(i);
        }

        int count1 = 0;
        int count2 = 0;
        for (int i = FILTE_SIZE; i < FILTE_SIZE + 100000; i++) {
            if (BLOOM_FILTER.mightContain(i)) {
                count1++;
            }
            if (BLOOM_FILTER2.mightContain(i)) {
                count2++;
            }
        }
        System.out.println("误判率:" + count1/100000.0);
        System.out.println("误判率:" + count2/100000.0);
    }
}
