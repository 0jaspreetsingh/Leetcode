package BreadthFirstSsearch;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/shortest-path-in-a-grid-with-obstacles-elimination/
 */
public class ShortestPath {

    static final int ipath[] = {1, 0, -1, 0};
    static final int jpath[] = {0, -1, 0, 1};

    class Node {
        int i, j, k;

        Node(int i, int j, int k) {
            this.i = i;
            this.j = j;
            this.k = k;
        }
    }

    public int shortestPath(int[][] grid, int k) {
        Queue<Node> queue = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        boolean arr[][][] = new boolean[m][n][k + 1];

        queue.add(new Node(0, 0, 0));
        int p = 0, q = 0;
        int counter = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int g = 0; g < size; g++) {
                Node node = queue.poll();
                if (node.i == m - 1 && node.j == n - 1) {
                    return counter;
                }
                // System.out.println(node);
                for (int i = 0; i < 4; i++) {
                    int ii = node.i + ipath[i];
                    int jj = node.j + jpath[i];
                    int kk = node.k;
                    if (isValid(ii, jj, m, n)) {
                        if (grid[ii][jj] == 1) {
                            kk++;
                        }
                        if (kk <= k && !arr[ii][jj][kk]) {
                            Node que = new Node(ii, jj, grid[ii][jj] + node.k);
                            queue.add(que);
                            arr[ii][jj][kk] = true;
                        }

                    }
                }
            }

            counter++;
        }

        return -1;
    }

    private static boolean isValid(int i, int j, int m, int n) {
        return i >= 0 & j >= 0 && i < m && j < n;
    }

    //**************** Better Version
//    private boolean[][][] visited;
//    private int m,n,min_step;
//    private int[][] NEXT={{0,1},{1,0},{0,-1},{-1,0}};
//
//    private void DFS(int[][] grid, int i,int j, int k, int step){
//        if(step >= min_step){
//            return;
//        }
//        if(i == m - 1 && j == n - 1){
//            min_step = Math.min(min_step,step);
//            return ;
//        }
//        visited[i][j][k]=true;
//        for (int[] next:NEXT){
//            int y = i + next[0],x = j + next[1];
//            if(0 <= y && y < m && 0 <= x && x < n && !visited[y][x][k]){
//                if(grid[y][x] == 0){
//                    DFS(grid,y,x,k,step+1);
//                } else if(k > 0){
//                    DFS(grid,y,x,k-1,step+1);
//                }
//            }
//        }
//    }
//
//    public int shortestPath(int[][] grid, int k) {
//        m = grid.length;
//        n = grid[0].length;
//        if(k >= m + n - 3){
//            return m + n - 2;
//        }
//        min_step = Integer.MAX_VALUE;
//        visited = new boolean[m][n][k + 1];
//        DFS(grid,0,0,k,0);
//        return min_step == Integer.MAX_VALUE ? -1 : min_step;
//    }
    //***************

    public static void main(String[] args) {
        ShortestPath sp = new ShortestPath();
        int grid[][] =
                {{0, 0, 0}, {1, 1, 0}, {0, 0, 0}, {0, 1, 1}, {0, 0, 0}},
                k = 1;
        System.out.println(sp.shortestPath(grid, k));
    }
}
