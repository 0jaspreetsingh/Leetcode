package arrays;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/largest-substring-between-two-equal-characters/
 */
public class SubStringWithEqualChar {

    public int maxLengthBetweenEqualCharacters(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        int ans = -1;
        char arr[] = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (hm.containsKey(arr[i])) {
                ans = Math.max(ans, i - hm.get(arr[i]) - 1);
            } else {
                hm.put(arr[i], i);
            }
        }
        return ans;
    }
}
