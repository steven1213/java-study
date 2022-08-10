package com.steven.algorithm.leetcode.tags.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum/
 */
public class Solution_1_00 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int key = nums[i];
            int temp = target - key;
            if (!map.containsKey(key)) {
                map.put(temp, i);
            } else {
                result[0] = map.get(key);
                result[1] = i;
                break;
            }
        }
        return result;
    }
}
