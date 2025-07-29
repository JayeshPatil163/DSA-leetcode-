// commented logic is not most optimal

class Solution {

    void bfs(int[][] isConnected, boolean[] vis, int i)
    {
        vis[i] = true;

        for(int j = 0; j < isConnected.length; j++)
        {
            if(isConnected[i][j] == 1 && !vis[j])
                bfs(isConnected, vis, j);
        }
    }

    public int findCircleNum(int[][] isConnected) {

        int n = isConnected.length;
        boolean[] vis = new boolean[n];
        int ans = 0;
        for(int i = 0; i < n; i++)
        {
            if(!vis[i])
            {
                bfs(isConnected, vis, i);
                ans++;
            }
        }

        return ans;

        // int n = isConnected.length;
        // int[] vis = new int[n];
        // Queue<Integer> queue = new LinkedList<>();
        // int ans = 0;

        // for(int i = 0; i < n; i++)
        // {
        //     if(vis[i] != 1)
        //     {
        //         vis[i] = 1;
        //         ans++;
        //         queue.add(i);
        //         while(!queue.isEmpty())
        //         {
        //             int t = queue.poll();
        //             for(int j = 0; j < n; j++)
        //             {
        //                 if(j != t && vis[j] == 0 && isConnected[t][j] == 1)
        //                 {
        //                     queue.add(j);
        //                     vis[j] = 1;
        //                 }
        //             }
        //         }
        //     }
        // }
        // return ans;
    }
}