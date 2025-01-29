package leetcode.twopointers;

import java.util.HashMap;

public class TwoIntegerSum {

    // O(n) time complexity
    // O(1) space complexity
    public static int[] solution1(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1, sum;

        while (l < r) {
            sum = numbers[l] + numbers[r];
            if (sum < target) {
                l++;
            } else if (sum > target) {
                r--;
            } else {
                return new int[]{++l, ++r};
            }
        }

        return new int[]{-1, -1};
    }

    // O(n) time complexity
    // O(n) space complexity
    public static int[] solution2(int[] numbers, int target) {
        var map = new HashMap<Integer, Integer>();

        int tmp;
        for (int i = 0; i < numbers.length; i++) {
            tmp = target - numbers[i];
            if (map.containsKey(tmp)) {
                return new int[]{map.get(tmp), ++i};
            }
            map.put(numbers[i], ++i);
        }
        return new int[]{-1, -1};
    }

    /*
    Binary search - cool!
    O(n logn) time complexity
    O(1) space complexity
     */
    public static int[] solution3(int[] numbers, int target) {
        int l, r, mid, tmp;
        for (int i = 0; i < numbers.length; i++) {
            l = i + 1;
            r = numbers.length - 1;
            tmp = target - numbers[i];
            while (l <= r) {
                mid = l + (r - l) / 2;
                if (numbers[mid] < tmp) {
                    l = mid + 1;
                } else if (numbers[mid] > tmp) {
                    r = mid - 1;
                } else {
                    return new int[]{++i, ++mid};
                }

            }
        }
        return new int[]{-1, -1};
    }
}
