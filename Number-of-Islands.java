class Solution {

    void findIlands(char[][] grid, int i, int j, int[] row, int[] col)
    {
        if(grid[i][j] == '0')
            return;

        grid[i][j] = '0';
        for(int k = 0; k < 4; k++)
        {
            int m = i + row[k], n = j + col[k];
            if(m >= 0 && n >= 0 && m < grid.length && n < grid[0].length)
            {
                findIlands(grid, m, n, row, col);
            }
        }
    }

    public int numIslands(char[][] grid) {
        int[] row = new int[]{0, -1, 0, 1};
        int[] col = new int[]{-1, 0, 1, 0};
        int ans = 0;
        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[0].length; j++)
            {
                if(grid[i][j] == '1')
                {
                    ans++;
                    findIlands(grid, i, j, row, col);
                }
            }
        }
        return ans;
    }
}