package techniques;

import java.util.HashSet;

/**
 * https://leetcode.com/problems/bitwise-ors-of-subarrays/
 */
public class BitwiseOrOnSubarrays {

    public int subarrayBitwiseORs(int[] A) {
        HashSet<Integer> ans = new HashSet();
        HashSet<Integer> hs = new HashSet();
        hs.add(0);
        for (int i : A) {
            HashSet<Integer> temp = new HashSet();
            for (int j : hs) {
                temp.add(j | i);
            }
            temp.add(i);
            hs = temp;
            ans.addAll(hs);
        }

        return ans.size();
    }
}
