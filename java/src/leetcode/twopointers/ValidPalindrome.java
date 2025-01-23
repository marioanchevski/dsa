package leetcode.twopointers;

public class ValidPalindrome {

    /**
     * O(n) time complexity where n is the length of the string
     * O(1) space complexity
     */
    public static boolean solution1(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {

            while (left < right && !isAlphaNumeric(s.charAt(left))) {
                left++;
            }

            while (right > left && !isAlphaNumeric(s.charAt(right))) {
                right--;
            }

            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    /**
     * O(n) time complexity
     * O(n) space complexity
     */
    public static boolean solution2(String s) {
        var strBuilder = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                strBuilder.append(Character.toLowerCase(c));
            }
        }
        return strBuilder.toString().contentEquals(strBuilder.reverse());
    }

    private static boolean isAlphaNumeric(char c) {
        return (c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z' || c >= '0' && c <= '9');
    }
}
