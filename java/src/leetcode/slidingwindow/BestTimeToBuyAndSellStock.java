package leetcode.slidingwindow;

public class BestTimeToBuyAndSellStock {

    // O(n) time complexity
    // O(1) space complexity
    public static int solution1(int[] prices) {
        int l = 0, r = l+1;
        int max = 0;
        while (r < prices.length) {

            if (prices[l] >= prices[r]) {
                r = ++l + 1;
            } else {
                max = Math.max(prices[r] - prices[l], max);
                ++r;
            }
        }
        return max;
    }
}
