package leetcode.twopointers;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,7,2,5,4,7,3,6}));
    }

    /**
     * O(n) time complexity
     * O(1) space complexity
     */
    public static int solution(int[] heights) {
        int left = 0, right = heights.length - 1, max = 0;

        while (left < right) {
            int leftHeight = heights[left], rightHeight = heights[right];
            max = Math.max((right - left) * Math.min(leftHeight, rightHeight), max);
            if (leftHeight < rightHeight) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
