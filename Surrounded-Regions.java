// Commented code id for old solution

class Solution {

    int flag = 1;
    int[][] vis;

    public void capture(char[][] board, int i, int j, int[] row, int[] col, int[][] vis)
    {
        // if(i == 0 || j == 0 || i == board.length - 1 || j == board[0].length - 1 || flag == 0)
        // {
        //     flag = 0;
        //     return;
        // }

        for(int k = 0; k < 4; k++)
        {
            int r = i + row[k];
            int c = j + col[k];
            if(r > 0 && c > 0 && r < board.length && c < board[0].length && board[r][c] == 'O' && vis[r][c] != 1)
            {
                vis[r][c] = 1;
                capture(board, r, c, row, col, vis);
            }
        }
        // if(flag == 1)
        //     board[i][j] = 'x';
    }

    public void solve(char[][] board) {
        int[] row = new int[]{0, 1, 0, -1};
        int[] col = new int[]{1, 0, -1, 0};
        int n = board[0].length;
        vis = new int[board.length][board[0].length];
        for(int i = 0; i < board.length; i++)
        {
            if(i == 0 || i == board.length - 1)
            {
                for(int j = 0; j < n; j++)
                {
                    if(board[i][j] == 'O' && vis[i][j] == 0)
                    {
                        vis[i][j] = 1;
                        capture(board, i, j, row, col, vis);
                    }
                }
            }
            else
            {
                if(board[i][0] == 'O' && vis[i][0] == 0)
                {
                    vis[i][0] = 1;
                    capture(board, i, 0, row, col, vis);
                }
                if(board[i][n - 1] == 'O' && vis[i][n - 1] == 0)
                {
                    vis[i][n - 1] = 1;
                    capture(board, i, n - 1, row, col, vis);
                }
            }
        }

        for(int i = 1; i < board.length - 1; i++)
        {
            for(int j = 1; j < n - 1; j++)
            {
                if(vis[i][j] == 0 && board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }

        // for(int i = 1; i < board.length - 1; i++)
        // {
        //     for(int j = 1; j < board[0].length - 1; j++)
        //     {
        //         if(board[i][j] != 'X')
        //         {
        //             vis = new int[board.length][board[0].length];
        //             capture(board, i, j, row, col, vis);
        //             if(flag == 1)
        //                 board[i][j] = 'X';
        //         }
        //         flag = 1;
        //     }
        // }
    }
}