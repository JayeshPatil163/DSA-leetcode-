class Solution {

    void dfs(int[][] grid, int i, int j, int[] row, int[] col)
    {
        grid[i][j] = 0;

        for(int k = 0; k < 4; k++)
        {
            int r = i + row[k];
            int c = j + col[k];
            if(r >= 0 && c >= 0 && r < grid.length && c < grid[0].length && grid[r][c] == 1)
            {
                dfs(grid, r, c, row, col);
            }
        }
    }

    public int numEnclaves(int[][] grid) {
        int[] row = {1, 0, -1, 0};
        int[] col = {0, 1, 0, -1};

        for(int i = 0; i < grid.length; i++)
        {
            if(grid[i][0] == 1)
                dfs(grid, i, 0, row, col);
            if(grid[i][grid[0].length - 1] == 1)
                dfs(grid, i, grid[0].length - 1, row, col);;
        }

        for(int i = 0; i < grid[0].length; i++)
        {
            if(grid[0][i] == 1)
                dfs(grid, 0, i, row, col);
            if(grid[grid.length - 1][i] == 1)
                dfs(grid, grid.length - 1, i, row, col);
        }

        //Old sol

        // for(int i = 0; i < grid.length; i++)
        // {
        //     if(i == 0 || i == grid.length - 1)
        //     {
        //         for(int j = 0; j < grid[0].length; j++)
        //         {
        //             if(grid[i][j] == 1)
        //                 dfs(grid, i, j, row, col);
        //         }
        //     }
        //     else
        //     {
        //         if(grid[i][0] == 1)
        //             dfs(grid, i, 0, row, col);
        //         if(grid[i][grid[0].length - 1] == 1)
        //             dfs(grid, i, grid[0].length - 1, row, col);
        //     }
        // }

        int count = 0;

        // for(int i = 1; i < grid.length; i++)
        // {
        //     for(int j = 1; j < grid[0].length; j++)
        //     {
        //         if(grid[i][j] == 1)
        //             count++;
        //     }
        // }

        for(int[] arr : grid)
        {
            for(int ele : arr)
            {
                if(ele == 1)
                    count++;
            }
        }

        return count;
    }
}