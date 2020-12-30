package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode.com/problems/maximal-network-rank/
 */
public class MaximumNetworkRank {
    public int maximalNetworkRank(int n, int[][] roads) {
        int ans = 0;
        int connections[] = new int[n];
        boolean directConnection[][] = new boolean[n][n];
        for (int road[] : roads) {
            connections[road[0]]++;
            connections[road[1]]++;
            directConnection[road[0]][road[1]] = true;
            directConnection[road[1]][road[0]] = true;
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                ans = Math.max(ans, connections[i] + connections[j] - (directConnection[i][j] ? 1 : 0));
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int n = 4, roads[][] = {{0, 1}, {0, 3}, {1, 2}, {1, 3}};
        MaximumNetworkRank mn = new MaximumNetworkRank();
        System.out.println(mn.maximalNetworkRank(n, roads));
    }

}
