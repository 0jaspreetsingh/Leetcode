package arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/queens-that-can-attack-the-king/
 */
public class NQueen {

    int x[] = {-1, -1, -1, 0, 0, 1, 1, 1};
    int y[] = {-1, 0, 1, -1, +1, -1, 0, 1};

    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean arr[][] = new boolean[8][8];
        for (int queen[] : queens) {
            arr[queen[0]][queen[1]] = true;
        }
        for (int i = 0; i < 8; i++) {
            int xx = king[0];
            int yy = king[1];
            while (check(xx + x[i], yy + y[i])) {
                xx += x[i];
                yy += y[i];
                if (arr[xx][yy]) {
                    List<Integer> ls = new ArrayList<>();
                    ls.add(xx);
                    ls.add(yy);
                    ans.add(ls);
                    break;
                }
            }
        }
        return ans;

    }

    private boolean check(int i, int j) {
        return i >= 0 && j >= 0 && i < 8 && j < 8;
    }

}
