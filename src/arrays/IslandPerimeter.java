package arrays;

/**
 * https://leetcode.com/problems/island-perimeter/
 */
public class IslandPerimeter {

    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        int len = grid.length;
        if (len == 0) return 0;
        int bred = grid[0].length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < bred; j++) {
                if (grid[i][j] == 1) {
                    perimeter += (i - 1) < 0 || grid[i - 1][j] == 0 ? 1 : 0;
                    perimeter += (i + 1) >= len || grid[i + 1][j] == 0 ? 1 : 0;
                    perimeter += (j - 1) < 0 || grid[i][j - 1] == 0 ? 1 : 0;
                    perimeter += (j + 1) >= bred || grid[i][j + 1] == 0 ? 1 : 0;
                }
            }
        }
        return perimeter;
    }
}
