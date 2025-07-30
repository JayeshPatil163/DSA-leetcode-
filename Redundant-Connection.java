// commented code is basic sol


class Solution {

    int[] parent;
    int[] rank;

    int find(int i)
    {
        if(parent[i] == i)
            return i;
        return parent[i] = find(parent[i]);
    }

    boolean union(int u, int v)
    {
        int ru = find(u);
        int rv = find(v);

        if(ru != rv)
        {

            if (rank[ru] < rank[rv]) {
                parent[ru] = rv;
            } else if (rank[rv] < rank[ru]) {
                parent[ru] = rv;
            } else {
                parent[rv] = ru;
                rank[ru]++;
            }
            return false;
        }
        return true;
    }

    public int[] findRedundantConnection(int[][] edges) {

        parent = new int[edges.length + 1];
        rank = new int[edges.length + 1];

        for(int i = 1; i < parent.length; i++)
            parent[i] = i;

        for(int[] edg : edges)
        {
            if(union(edg[0], edg[1]))
                return edg;

        }

        return new int[0];

        // int[] visp = new int[edges.length + 1];
        // int[] visc = new int[edges.length + 1];
        // int[] ans = new int[2];

        // for(int i = 0; i < edges.length; i++)
        // {
        //     if(visc[edges[i][1]] == 1 && (visp[edges[i][0]] == 1 || visc[edges[i][0]]))
        //     {
        //         ans = edges[i];
        //     }
        //     else
        //     {
        //         visc[edges[i][1]] = 1;
        //         visp[edges[i][0]] = 1;
        //     }
        // }

        // return ans;
    }
}