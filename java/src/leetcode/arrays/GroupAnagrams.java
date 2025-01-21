package leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public static void main(String[] args) {
       var strs = new String[]{"act","pots","tops","cat","stop","hat"};
        System.out.println(solution1(strs));
    }

    // O(n * mlogm) time complexity where n is the length of strs and m is the length of the longest str
    // O(n * m) space complexity
    public static List<List<String>> solution1(String[] strs) {
        var result = new HashMap<String, List<String>>();
        for (var str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            var key = String.valueOf(charArray);
            result.putIfAbsent(key, new ArrayList<>());
            result.get(key).add(str);
        }
        return new ArrayList<>(result.values());
    }

    // O(n * m) time complexity where n is length of strs and m is the length of the longest str
    // O(n * m) space complexity
    public static List<List<String>> solution2(String[] strs) {
        var result = new HashMap<String, List<String>>();

        for (var str : strs) {
            int[] count = new int[26];
            for (char ch : str.toCharArray()) {
                count[ch - 'a']++;
            }
            var charArrayString = Arrays.toString(count);
            result.putIfAbsent(charArrayString, new ArrayList<>());
            result.get(charArrayString).add(str);
        }
        return new ArrayList<>(result.values());
    }
}
