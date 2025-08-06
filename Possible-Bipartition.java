class Solution {
    public boolean possibleBipartition(int k, int[][] dislikes) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i <= k; i++)
            list.add(new ArrayList<>());

        for(int i = 0; i < dislikes.length; i++)
        {
            list.get(dislikes[i][0]).add(dislikes[i][1]);
            list.get(dislikes[i][1]).add(dislikes[i][0]);
        }

        int[] vis = new int[k + 1];

        for(int i = 0; i <= k; i++)
        {
            if(vis[i] == 0)
            {
                vis[i] = 1;
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                while(!queue.isEmpty())
                {
                    int ele = queue.poll();
                    for(int num : list.get(ele))
                    {
                        if(vis[num] == vis[ele])
                            return false;
                        else if(vis[num] == 0)
                        {
                            vis[num] = vis[ele] * -1;
                            queue.add(num);
                        }
                    }
                }



                // while (!queue.isEmpty()) {
                //     int u = queue.poll();
                //     for (int v : list.get(u)) {
                //         if (vis[v] == 0) { // If neighbor is uncolored
                //             vis[v] = vis[u] * -1; // Color with the opposite group
                //             queue.add(v);
                //         } else if (vis[v] == vis[u]) { // If neighbor has the same color
                //             return false; // Not a bipartite graph
                //         }
                //     }
                // }
            }
        }
        return true;

        // int n = dislikes.length;

        // for(int i = 0; i < n; i++)
        // {
        //     if(vis[dislikes[i][0]] == 0 && vis[dislikes[i][1]] == 0)
        //     {
        //         vis[dislikes[i][0]] = -1;
        //         vis[dislikes[i][1]] = 1;
        //     }
        //     else if(vis[dislikes[i][0]] == vis[dislikes[i][1]])
        //         return false;
        //     else if(vis[dislikes[i][0]] != 0)
        //         vis[dislikes[i][1]] = vis[dislikes[i][0]] * -1;
        //     else
        //         vis[dislikes[i][0]] = vis[dislikes[i][1]] * -1;
        // }
        // return true;
    }
}