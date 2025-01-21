package leetcode.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    // O(n^2) time complexity
    // O(1) space complexity
    public static boolean solution1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    // O(n) time complexity
    // O(n) space complexity
    public static boolean solution2(int[] nums) {
        return nums.length > Set.of(nums).size();
    }

    // O(nlogn) time complexity
    // O(1) space complexity (or O(n) depending on the sorting algorithm)
    public static boolean solution3(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }
        return false;
    }

    // O(n) time complexity
    // O(n) space complexity
    public static boolean solution4(int[] nums) {
        var set = new HashSet<Integer>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }
}
