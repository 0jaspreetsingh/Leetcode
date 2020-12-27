package Graph;

import java.util.*;

/**
 * https://leetcode.com/problems/sum-of-distances-in-tree/
 * hard
 */
public class SumOfDistancesOfTree {

    int ans[];
    int child[];
    List<HashSet<Integer>> list;


    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        ans = new int[N];
        child = new int[N];

        list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(new HashSet<>());
        }
        for (int edge[] : edges) {
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }
        dfs(0, -1);
        dfs2(0, -1);
        return ans;
    }

    private void dfs(int node, int parent) {
        for (int i : list.get(node)) {
            if (i == parent) continue;
            dfs(i, node);
            child[node] += child[i];
            ans[node] += ans[i] + child[i];
        }
        child[node]++;
    }

    private void dfs2(int node, int parent) {
        for (int i : list.get(node)) {
            if (i == parent) continue;
            //child[i] nodes get one step away , and total - child[i] nodes gets one step closer
            ans[i] = ans[node] - child[i] + child.length - child[i];
            dfs2(i, node);
        }
    }


    public static void main(String[] args) {
        int N = 6, edges[][] = {{0, 1}, {0, 2}, {2, 3}, {2, 4}, {2, 5}};
        SumOfDistancesOfTree sm = new SumOfDistancesOfTree();
        System.out.println(Arrays.toString(sm.sumOfDistancesInTree(N, edges)));
    }
}
