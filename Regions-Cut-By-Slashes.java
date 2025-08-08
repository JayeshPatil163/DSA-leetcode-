class Solution {
    public int regionsBySlashes(String[] grid) {
        int n = grid.length * 3;
        int[][] pattern = new int[n][n];
        int r = 0;
        int c = 0;
        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[i].length(); j++)
            {
                if(grid[i].charAt(j) == '/')
                {
                    pattern[r][c + 2] = 1;
                    pattern[r + 1][c + 1] = 1;
                    pattern[r + 2][c] = 1;
                }
                if(grid[i].charAt(j) == '\\')
                {
                    pattern[r][c] = 1;
                    pattern[r + 1][c + 1] = 1;
                    pattern[r + 2][c + 2] = 1;
                }
                c += 3;
            }
            r += 3;
            c = 0;
        }

        int[] row = {0, 1, 0, -1};
        int[] col = {1, 0, -1, 0};
        int ans = 0;

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                // System.out.print(pattern[i][j] + " ");
                if(pattern[i][j] == 0)
                {
                    dfs(pattern, row, col, i, j);
                    ans++;
                }
            }
            // System.out.println();
        }

        return ans;
    }

    void dfs(int[][] pattern, int[] row, int[] col, int i, int j)
    {
        pattern[i][j] = 1;
        for(int k = 0; k < 4; k++)
        {
            int r = i + row[k];
            int c = j + col[k];
            if(r >= 0 && c >= 0 && r < pattern.length && c < pattern.length && pattern[r][c] != 1)
            {
                dfs(pattern, row, col, r, c);
            }
        }
    }
}