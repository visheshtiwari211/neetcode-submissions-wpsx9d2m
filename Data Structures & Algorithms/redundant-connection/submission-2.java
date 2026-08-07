class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];
        parent[0] = -1;
        for (int i = 1; i <= n; i++) {
            parent[edges[i - 1][0]] = edges[i - 1][0];
            parent[edges[i - 1][1]] = edges[i - 1][1];
        }

        for (int i = 1; i <= n; i++) {
            int parentFirst = find(edges[i - 1][0], parent, edges);
            int parentSecond = find(edges[i - 1][1], parent, edges);
            if(parentFirst != parentSecond) {
                parent[parentFirst] = parentSecond;
            } else {
                return edges[i-1];
            }
        }

        return new int[2];
    }

    public int find(int i, int[] parent, int[][] edges) {
        int curr = parent[i];
        while (parent[curr] != curr) {
            curr = parent[curr];
        }
        return curr;
    }
}
