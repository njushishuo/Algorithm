package array;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum/solution/
 * 每个元素只能使用一次，只有唯一解
 * 我的解法： O(n2) O(1)
 * 第二种解法：空间换时间：O(n2)产生的原因是，对于每一个nums[i]需要遍历整个数组才能知道数组中是否存在一个匹配的值。
 *           数组只能根据下标访问值，但是反向查询（即根据值查询下标）是做不到的，利用map来达到这一目的
 * 第三种解法：不需要事先遍历一遍数组来存储所有值和下标，而是一遍遍历数组一遍比对现有的map，找到匹配就立即返回;找不到就存储当前的值
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[] { i, j };
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }


    public int[] twoSumWithHashMap(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }


    public int[] twoSumWithHashMapOptimize(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

}
