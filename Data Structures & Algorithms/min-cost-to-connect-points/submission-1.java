class Solution {
    class Edge implements Comparable<Edge> {
        int start, dest, weight;

        Edge(int start, int dest, int weight) {
            this.start = start;
            this.dest = dest;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.weight, other.weight);
        }

    }

    class DSU {
        int[] parent, rank;

        DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            for(int i = 0; i<n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        public int find(int i) {
            if(parent[i] != i) {
                parent[i] = find(parent[i]);
            }
            return parent[i];
        }

        public boolean union(int x, int y) {
            int rootx = find(x);
            int rooty = find(y);

            if(rootx == rooty) return false;

            if(rank[rootx] < rank[rooty]) {
                parent[rootx] = rooty;
            } else if (rank[rooty] < rank[rootx]) {
                parent[rooty] = rootx;
            } else {
                parent[rootx] = rooty;
                rank[rooty]++;
            }
            return true;
        }
    }
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        if (n <= 1) return 0;
        List<Edge> edges = new ArrayList<>();
        for(int i = 0; i<points.length; i++) {
            for(int j = i+1; j<points.length; j++) {
                int wt = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]); 
                edges.add(new Edge(i, j, wt));
            }
        }
        Collections.sort(edges);

        int totalWeight = 0;
        int noOfNodes = 0;
        DSU dsu = new DSU(points.length);

        for(Edge edge: edges) {
            if(dsu.union(edge.start, edge.dest)) {
                totalWeight += edge.weight;
                noOfNodes++;
            }

            if(noOfNodes == points.length - 1) break;
        }

        return totalWeight;
    }
}
