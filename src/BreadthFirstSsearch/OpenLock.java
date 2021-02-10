package BreadthFirstSsearch;

import java.util.HashMap;
import java.util.HashSet;

/**
 * https://leetcode.com/problems/open-the-lock/
 * todo
 */
public class OpenLock {

    int ans = Integer.MAX_VALUE;

    public int openLock(String[] deadends, String target) {

        HashSet<String> hs = new HashSet<>();
        for (String end : deadends) {
            hs.add(end);
        }
        int start[] = new int[4];
        HashMap<String, Integer> hm = new HashMap<>();
        openLock(hs, hm, target, "0000");
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private int openLock(HashSet<String> hs, HashMap<String, Integer> hm, String target, String currAns) {
        if (hm.containsKey(currAns)) {
            return hm.get(currAns);
        }
//        for (int i = 0; i < 4; i++) {
//
//            int ansAdd = openLock(hs, hm, target, newAddAns);
//            int ansSub = openLock(hs, hm, target, newSubAns);
//        }
        return 0;
    }

}
