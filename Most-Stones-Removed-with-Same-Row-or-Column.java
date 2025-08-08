class Solution {
    public int removeStones(int[][] stones) {

        UnionFind uf = new UnionFind();
        for (int[] stone : stones) {
            int rowId = stone[0];
            int colId = stone[1] + 10001;
            uf.union(rowId, colId);
        }

        return stones.length - uf.getCount();

        // DFS solution

        // int n = stones.length;
        // int count = 0;
        // int[] vis = new int[n];
        // for(int i = 0; i < n; i++)
        // {
        //     if(vis[i] != 1)
        //     {
        //         dfs(i, vis, stones);
        //         count++;
        //     }
        // }
        // return n - count;
    }

    // void dfs(int i, int[] vis, int[][] stones)
    // {
    //     vis[i] = 1;
    //     int r = stones[i][0];
    //     int c = stones[i][1];
    //     for(int j = 0; j < stones.length; j++)
    //     {
    //         if(vis[j] != 1 && (r == stones[j][0] || c == stones[j][1]))
    //             dfs(j, vis, stones);
    //     }
    // }
}

class UnionFind {
    private Map<Integer, Integer> parent;
    private int count;

    public UnionFind() {
        this.parent = new HashMap<>();
        this.count = 0;
    }

    public int find(int i) {
        if (!parent.containsKey(i)) {
            parent.put(i, i);
            count++;
        }
        if (parent.get(i) == i) {
            return i;
        }
        parent.put(i, find(parent.get(i)));
        return parent.get(i);
    }

    public void union(int i, int j) {
        int rootI = find(i);
        int rootJ = find(j);
        if (rootI != rootJ) {
            parent.put(rootI, rootJ);
            count--;
        }
    }

    public int getCount() {
        return count;
    }
}