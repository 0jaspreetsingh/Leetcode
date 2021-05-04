package DepthFirstSearch;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/coloring-a-border/
 */
public class ColorAborder {

    int row[] = {-1, 0, +1, 0};
    int col[] = {0, +1, 0, -1};

    List<Node> list;

    private class Node {
        int i, j;

        Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {

        int prevColor = grid[r0][c0];
        this.list = new ArrayList<>();
        dfs(grid, r0, c0, prevColor);

        for (Node node : list) {
            if (grid[node.i][node.j] < 0) grid[node.i][node.j] = color;
        }
        return grid;
    }

    private void dfs(int[][] grid, int r0, int c0, int prevcolor) {
        if (!isValid(grid, r0, c0)) return;
        if (grid[r0][c0] == prevcolor) {
            list.add(new Node(r0, c0));
            grid[r0][c0] = -prevcolor;
            for (int i = 0; i < 4; i++) {
                int r1 = r0 + row[i];
                int c1 = c0 + col[i];
                dfs(grid, r1, c1, prevcolor);
            }
            if (r0 > 0 && c0 > 0 && r0 < grid.length - 1
                    && c0 < grid[0].length - 1
                    && prevcolor == Math.abs(grid[r0 + 1][c0])
                    && prevcolor == Math.abs(grid[r0][c0 + 1])
                    && prevcolor == Math.abs(grid[r0 - 1][c0])
                    && prevcolor == Math.abs(grid[r0][c0 - 1])) {
                grid[r0][c0] = prevcolor;
            }
        }
    }


    private boolean isValid(int[][] grid, int r0, int c0) {
        return r0 >= 0 && c0 >= 0 && r0 < grid.length && c0 < grid[0].length;
    }
}
