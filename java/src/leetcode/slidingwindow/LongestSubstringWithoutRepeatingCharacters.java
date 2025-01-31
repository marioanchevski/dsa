package leetcode.slidingwindow;

import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {

    // O(n) time complexity
    // O(m) space complexity where m is the number of unique characters in the string
    public static int solution1(String s) {

        var set = new HashSet<Character>();
        int l = 0, r = 0;
        int max = 0;

        while (r < s.length()) {
            if (!set.contains(s.charAt(r))) {
                set.add(s.charAt(r));
                max = Math.max(max, r - l + 1);
                ++r;
            } else {
                set.remove(s.charAt(l));
                ++l;
            }
        }
        return max;
    }

    // O(n) time complexity
    // O(m) space complexity where m is the total number of unique characters in the string
    public static int solution2(String s) {

        var map = new HashMap<Character, Integer>();
        int l = 0, max = 0;
        for (int r = 0; r < s.length(); r++) {
            if (map.containsKey(s.charAt(r))) {
                l = Math.max(map.get(s.charAt(r)) + 1, l);
            }
            map.put(s.charAt(r), r);
            max = Math.max(max, r - l + 1);
        }
        return max;
    }
}
