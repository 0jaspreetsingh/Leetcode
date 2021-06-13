package techniques;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/
 */
public class MaxLenConcatenatedStringWithUniqueChars {

    public int maxLength(List<String> arr) {
        List<Integer> dp = new ArrayList<Integer>();
        dp.add(0);
        1239. Maximum Length of a Concatenated String with Unique Characters
        int ans = 0;
        for (String s : arr) {
            int a = 0, dup = 0;
            for (char c : s.toCharArray()) {
                dup |= a & (1 << (c - 'a'));
                a |= (1 << (c - 'a'));
            }
            if (dup > 0) continue;
            for (int i = dp.size() - 1; i >= 0; i--) {
                if ((dp.get(i) & a) > 0) continue;
                dp.add(dp.get(i) | a);
                ans = Math.max(ans, Integer.bitCount(dp.get(i) | a));
            }
        }
        return ans;
    }
}
