package main;

/**
 * https://leetcode.com/problems/maximum-product-of-word-lengths/
 */
public class MaxProductOfWordLengths {

    public int maxProduct(String[] words) {
        int maxprod = 0;
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                maxprod = Math.max(maxprod, check(words[i], words[j]));
            }
        }
        return maxprod;
    }


    private int check(String s1, String s2) {
        int arr[] = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            arr[s1.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s2.length(); i++) {
            if (arr[s2.charAt(i) - 'a'] > 0) {
                return 0;
            }
        }
        return s1.length() * s2.length();
    }
}
