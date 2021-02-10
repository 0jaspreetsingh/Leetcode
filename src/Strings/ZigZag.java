package Strings;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/zigzag-conversion/
 */
public class ZigZag {

    public String convert(String s, int numRows) {
        List<StringBuilder> ls = new ArrayList<>();
        StringBuilder ans = new StringBuilder();
        if (numRows == 1) {
            return s;
        }
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            ls.add(new StringBuilder());
        }
        boolean goingDown = false;
        int currIndex = 0;
        for (char c : s.toCharArray()) {
            ls.get(currIndex).append(c);
            if (currIndex == 0 || currIndex == s.length() - 1) goingDown = !goingDown;
            currIndex += goingDown ? 1 : -1;
        }

        for (StringBuilder sb : ls) ans.append(sb);

        return ans.toString();
    }
}
