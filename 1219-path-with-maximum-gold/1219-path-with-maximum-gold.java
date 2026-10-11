class Solution {
    int result;

    public int getMaximumGold(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0)
                    travel(i, j, grid, 0);
            }
        }
        return result;
    }

    public void travel(int i, int j, int[][] grid, int path) {
        if (grid[i][j] == 0)
            result = Math.max(result, path);
        else {
            int temp = grid[i][j];
            path += temp;
            grid[i][j] = 0;

            if (i + 1 < grid.length)
                travel(i + 1, j, grid, path);
            if (i - 1 >= 0)
                travel(i - 1, j, grid, path);
            if (j + 1 < grid[0].length)
                travel(i, j + 1, grid, path);
            if (j - 1 >= 0)
                travel(i, j - 1, grid, path);

            grid[i][j] = temp;
            path -= temp;
        }
    }

}