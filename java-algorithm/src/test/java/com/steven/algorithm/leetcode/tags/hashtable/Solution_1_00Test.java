package com.steven.algorithm.leetcode.tags.hashtable;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution_1_00Test {

    /**
     * nums = [2,7,11,15], target = 9
     */
    @Test
    void twoSum_simple_1() {
        int[] result = new Solution_1_00().twoSum(new int[]{2, 7, 11, 15}, 9);
        assertTrue(result[0] == 0 && result[1] == 1);
    }

    /**
     * nums = [3,2,4], target = 6
     */
    @Test
    void twoSum_simple_2() {
        int[] result = new Solution_1_00().twoSum(new int[]{3, 2, 4}, 6);
        assertTrue(result[0] == 1 && result[1] == 2);
    }

    /**
     * nums = [3,3], target = 6
     */
    @Test
    void twoSum_simple_3() {
        int[] result = new Solution_1_00().twoSum(new int[]{3, 3}, 6);
        assertTrue(result[0] == 0 && result[1] == 1);
    }
}