package leetcode.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        System.out.println(solution2(new int[]{2, 20, 4, 10, 3, 4, 5}));
    }


    // O(n) time complexity
    // O(n) space complexity
    public static int solution1(int[] nums) {
        var set = IntStream.of(nums)
                .boxed()
                .collect(Collectors.toSet());

        int max = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int streak = 1;
                while (set.contains(num + streak)) {
                    streak++;
                }
                max = Math.max(max, streak);
            }
        }
        return max;
    }

    // O(nlogn) time complexity
    // O(1) or O(n) depending on the sorting algorithm
    public static int solution2(int[] nums) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums);

        int res = 0, cur = nums[0], streak = 0, i = 0;
        while (i < nums.length) {
            if (cur != nums[i]) {
                cur = nums[i];
                streak = 0;
            }

            while (i < nums.length && nums[i] == cur) i++;

            streak++;
            cur++;
            res = Math.max(res, streak);
        }

        return res;
    }

    // O(n) time complexity
    // O(n) space complexity
    public static int solution3(int[] nums) {
        var map = new HashMap<Integer, Integer>();
        int res = 0;

        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, map.getOrDefault(num - 1, 0) + map.getOrDefault(num + 1, 0) + 1);

                map.put(num - map.getOrDefault(num - 1, 0), map.get(num));
                map.put(num + map.getOrDefault(num + 1, 0), map.get(num));
                res = Math.max(res, map.get(num));
            }
        }
        return res;
    }
}
