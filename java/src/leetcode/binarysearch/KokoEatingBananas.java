package leetcode.binarysearch;


import java.util.Arrays;

public class KokoEatingBananas {
    public static void main(String[] args) {
        System.out.println(solution2(new int[]{332484035, 524908576, 855865114, 632922376, 222257295, 690155293, 112677673, 679580077, 337406589, 290818316, 877337160, 901728858, 679284947, 688210097, 692137887, 718203285, 629455728, 941802184}, 823855818));
    }


    // O(n*logm) time complexity where n is the size of piles and m is the largest pile
    // O(1) space complexity
    public static int solution2(int[] piles, int h) {
        int l = 1;
        int r = Arrays.stream(piles).max().getAsInt();
        int res = r;

        while (l <= r) {
            int m = l + (r - l) / 2;
            long sum = 0;
            for (int pile : piles) {
                sum += (long) Math.ceil(pile * 1.0 / m);
            }
            if (sum <= h) {
                res = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return res;
    }

    // O(n*m) where m is the largest pile time complexity
    // O(1) or O(n) space complexity depending on the sorting algorithm
    public static int solution1(int[] piles, int h) {
        Arrays.sort(piles);
        int res = 0;
        for (int i = 1; i <= piles[piles.length - 1]; i++) {
            long sum = 0;
            for (int pile : piles) {
                sum += ((long) Math.ceil(pile * 1.0 / i));
            }
            if (sum <= h) return i;
        }
        return res;
    }
}

