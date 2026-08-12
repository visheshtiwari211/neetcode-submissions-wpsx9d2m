class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList());
        }
        for (int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        int gMin = Integer.MAX_VALUE;
        List<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[n];
        for (int j = 0; j < adj.size(); j++) {
            visited = new boolean[n];
            int height = find(j, adj, 0, visited);
            if (height < gMin) {
                gMin = height;
                ans.clear();
                ans.add(j);

            } else if (height == gMin) {
                ans.add(j);
            }
        }
        return ans;
    }

    public int find(int root, List<List<Integer>> adj, int height, boolean[] visited) {
        int dis = 0;
        visited[root] = true;
        for (int i = 0; i < adj.get(root).size(); i++) {
            if (visited[adj.get(root).get(i)])
                continue;
            dis = Math.max(dis, find(adj.get(root).get(i), adj, height + 1, visited));
        }
        return dis + 1;
    }
}