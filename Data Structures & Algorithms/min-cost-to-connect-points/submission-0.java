class Solution {
    class Edge implements Comparable<Edge> {
        int u, v, weight;

        public Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.weight, other.weight);
        }
    }

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        if (n <= 1) return 0;

        List<Edge> edges = new ArrayList<>();
        
        // Build all pairwise edges with vertex indices
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int wt = Math.abs(points[i][0] - points[j][0]) 
                       + Math.abs(points[i][1] - points[j][1]);
                edges.add(new Edge(i, j, wt));
            }
        }

        Collections.sort(edges);

        DSU dsu = new DSU(n);
        int totalWeight = 0;
        int edgesCount = 0;

        for (Edge edge : edges) {
            if (dsu.union(edge.u, edge.v)) {
                totalWeight += edge.weight;
                edgesCount++;
                
                // Stop early once all (n - 1) edges are formed
                if (edgesCount == n - 1) {
                    break;
                }
            }
        }

        return totalWeight;
    }

    class DSU {
        private int[] parent;
        private int[] rank;

        public DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        public int find(int i) {
            if (parent[i] != i) {
                parent[i] = find(parent[i]); // Path compression
            }
            return parent[i];
        }

        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY) {
                return false;
            }

            if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
            return true;
        }
    }
}