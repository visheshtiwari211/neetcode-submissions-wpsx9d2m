class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return Collections.singletonList(0);
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList());
        }
        for (int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        int[] degree = new int[n];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < adj.size(); i++) {
            degree[i] = adj.get(i).size();
        }

        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 1) {
                q.add(i);
            }
        }
        int remainingNodes = n;
        while (remainingNodes > 2) {
            int size = q.size();
            remainingNodes -= size;
            while (size > 0) {
                int node = q.poll();
                for(int i: adj.get(node)) {
                    degree[i] -= 1;
                    if(degree[i] == 1) q.add(i);
                }
                size--;
            }

        }
        List<Integer> res = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            res.add(node);
        }
        return res;
    }
}