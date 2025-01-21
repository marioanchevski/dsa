package leetcode.arrays;

import java.util.HashMap;

public class TwoSum {

    // O(n^2) time complexity
    // O(1) space complexity
    public static int[] solution1(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    // O(n) time complexity
    // O(n) space complexity
    public static int[] solution2(int[] nums, int target) {
        var hashMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int difference = target - nums[i];
            if (hashMap.containsKey(difference) && hashMap.get(difference) != i) {
                return new int[]{i, hashMap.get(difference)};
            }
        }
        return new int[]{-1, -1};
    }
}
