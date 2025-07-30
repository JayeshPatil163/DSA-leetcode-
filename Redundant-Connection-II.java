class Solution {

    int[] parent;

    int find(int i) {
        if (parent[i] == i)
            return i;
        return parent[i] = find(parent[i]); //Path compression here
    }

    boolean union(int u, int v) {
        u = find(u);
        v = find(v);

        if (u != v) {
            parent[v] = u;
            return false;
        }
        return true;
    }

    public int[] findRedundantDirectedConnection(int[][] edges) {
        // We'll use previous solution but by adding parent child relation carefully and hopefully it works.

        parent = new int[edges.length + 1];
        int[] inparent = new int[edges.length + 1];
        for (int i = 1; i <= edges.length; i++)
            parent[i] = i;

        int[] edge1 = null;
        int[] edge2 = null;

        for (int[] i : edges) {
            if (inparent[i[1]] != 0) {
                edge1 = new int[] { inparent[i[1]], i[1] };
                edge2 = i;
            } else
                inparent[i[1]] = i[0];
        }

        if (edge2 == null) {
            for (int[] edg : edges) {
                if (union(edg[0], edg[1]))
                    return edg;
            }
        } else {
            for (int i[] : edges) {
                if (i[0] == edge2[0] && i[1] == edge2[1])
                    continue;

                if (union(i[0], i[1])) {
                    return edge1;
                }
            }
            return edge2;
        }

        return new int[0];
    }
}

// In conclusion it did worked for some part but as this is directed graph we need to handle it with some extra work.

// When we encounter a child which has two parents we need to consider that too which we are doint with inParent here.

// It detects if the child already has parent then it won't be 0 when checkign and hence we'll know that and then the edge2 will change and it won't be null and this will allow use to avoid checking cycles as it's not probem cause we have encountered two parents, so now in else we will check for cycles and will return edge2 if no cycle was found there and if yes then we return that earlier edge as it was first unwanted edge.