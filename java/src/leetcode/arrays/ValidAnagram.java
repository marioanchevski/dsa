package leetcode.arrays;

import java.util.Arrays;
import java.util.HashMap;

public class ValidAnagram {

    // O(n + m) time complexity ( where n is the length of s, m is the length of t )
    // O(1) space complexity ( since we have at most 26 chars )
    public static boolean solution1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        return Arrays.stream(count).allMatch(i -> i == 0);
    }

    // O(n+m) time complexity
    // O(1) space complexity ( since we have at most 26 letters )
    public static boolean solution2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        var countS = new HashMap<Character, Integer>();
        var countT = new HashMap<Character, Integer>();

        for (int i = 0; i < s.length(); i++) {
            countS.put(s.charAt(i), countS.getOrDefault(s.charAt(i), 0) + 1);
            countT.put(s.charAt(i), countT.getOrDefault(s.charAt(i), 0) + 1);
        }

        return countS.equals(countT);
    }

    // O(nlogn + mlogm) time complexity
    // O(1) space complexity or O(n+m) depending on the sorting algorithm
    public static boolean solution3(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        Arrays.sort(sArr);
        Arrays.sort(tArr);

        return Arrays.equals(sArr, tArr);
    }
}
