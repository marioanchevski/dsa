package leetcode.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        System.out.println(solution2(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    /*
    Brute force
    O(n^3) time complexity
    O(k) space complexity where k is the number of unique triplets
     */
    public static List<List<Integer>> solution1(int[] nums) {
        Arrays.sort(nums);

        var set = new HashSet<List<Integer>>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        set.add(List.of(nums[i], nums[j], nums[k]));
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }

    // O(n^2) time complexity
    // O(1) or O(n) depending on the sorting algorithm
    public static List<List<Integer>> solution2(int[] nums) {
        Arrays.sort(nums);
        var result = new ArrayList<List<Integer>>();

        for (int i = 0; i < nums.length; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) continue;
            if (nums[i] > 0) break;

            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                }
            }
        }
        return result;
    }
}
