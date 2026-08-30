class Solution {
    public int minCostConnectPoints(int[][] points) {
        int V = points.length;
        int[] key = new int[V];
        boolean[] visited = new boolean[V];

        for(int i = 0; i<V; i++) {
            key[i] = Integer.MAX_VALUE;
        }
        key[0] = 0;

        int totalCost = 0;

        for(int i = 0; i<V; i++) {
            int u = findMinIndex(key, visited);
            visited[u] = true;
            totalCost += key[u];
            for(int v = 0; v < V; v++) {
                if(!visited[v]) {
                    int dist = Math.abs(points[v][0] - points[u][0]) + Math.abs(points[v][1] - points[u][1]);
                    if(dist < key[v]) {
                        key[v] = dist;
                    }
                }
            }
        }
        return totalCost;
    }

    public int findMinIndex(int[] key, boolean[] visited) {
        int min = Integer.MAX_VALUE, idx = -1;

        for(int i = 0; i<key.length; i++) {
            if(!visited[i] && key[i] < min) {
                min = key[i];
                idx = i;
            }
        }

        return idx;
    }
}
