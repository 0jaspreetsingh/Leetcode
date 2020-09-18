package Strings;

import java.util.Arrays;

public class LongestSubstringWithKRepeatingChars {

    int ans;


    public int longestSubstring(String s, int k) {
        ans = 0;
        check(s, k);
        return ans;
    }

    private boolean check(String s, int k) {


        int len = s.length();
        if (len < k) {
            return false;
        }
        if (isValid(s, k)) {
            if (ans < s.length()) {
                ans = s.length();
            }
            return true;
        }

        check(s.substring(1), k);
        check(s.substring(0, len - 1), k);

        return false;
    }

    private boolean isValid(String str, int k) {
        int arr[] = new int[26];
        for (char c : str.toCharArray()) {
            arr[c - 'a']++;
        }

        for (char c : str.toCharArray()) {
            if (arr[c - 'a'] < k) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        LongestSubstringWithKRepeatingChars l = new LongestSubstringWithKRepeatingChars();
        System.out.println(l.longestSubstring("aacbbbdc", 2));
    }
}
