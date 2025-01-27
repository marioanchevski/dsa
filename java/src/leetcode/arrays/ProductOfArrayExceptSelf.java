package leetcode.arrays;

public class ProductOfArrayExceptSelf {

    // O(n^2) time complexity
    // O(n) space complexity
    public static int[] solution1(int[] nums) {
        var res = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int prod = 1;
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    prod *= nums[j];
                }
            }
            res[i] = prod;
        }
        return res;
    }

    // O(n) time complexity
    // O(n) space complexity
    public static int[] solution2(int[] nums) {
        int n = nums.length;
        int[] res = new int[n], prefix = new int[n], suffix = new int[n];

        prefix[0] = 1;
        suffix[n - 1] = 1;
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }

        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < n; i++) {
            res[i] = prefix[i] * suffix[i];
        }

        return res;
    }

    // O(n) time complexity
    // O(n) space complexity
    public static int[] solution3(int[] nums){
        int n = nums.length;
        int[] res = new int[n];

        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i]  = res[i - 1] * nums[i - 1];
        }

        int postfix = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= postfix;
            postfix *= nums[i];
        }

        return res;
    }
}
