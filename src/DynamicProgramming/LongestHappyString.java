package DynamicProgramming;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/longest-happy-string/
 * todo
 */
public class LongestHappyString {

    public String longestDiverseString(int a, int b, int c) {
        int maxLen = a + b + c;
        StringBuilder sb = new StringBuilder();
        int A = 0, B = 0, C = 0;
        for (int i = 0; i < maxLen; i++) {
            if ((a >= b && a >= c && A != 2) || (B == 2 && a > 0) || (C == 2 && a > 0)) {
                a--;
                sb.append("a");
                A++;
                B = 0;
                C = 0;
            } else if ((b >= a && b >= c && B != 2) || (A == 2 && b > 0) || (C == 2 && b > 0)) {
                b--;
                sb.append("b");
                B++;
                A = 0;
                C = 0;
            } else if ((c >= b && c >= a && C != 2) || (B == 2 && c > 0) || (A == 2 && c > 0)) {
                c--;
                sb.append("c");
                C++;
                B = 0;
                A = 0;
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        LongestHappyString lg = new LongestHappyString();
        System.out.println(lg.longestDiverseString(1, 1, 7));
    }
}
