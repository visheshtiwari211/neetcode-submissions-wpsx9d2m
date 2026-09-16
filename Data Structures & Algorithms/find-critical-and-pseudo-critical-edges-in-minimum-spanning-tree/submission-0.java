class Solution {
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        int m = edges.length;

        // Store: [u, v, weight, original_index]
        int[][] sortedEdges = new int[m][4];
        for (int i = 0; i < m; i++) {
            sortedEdges[i][0] = edges[i][0];
            sortedEdges[i][1] = edges[i][1];
            sortedEdges[i][2] = edges[i][2];
            sortedEdges[i][3] = i;
        }

        // Sort by edge weight
        Arrays.sort(sortedEdges, (a, b) -> Integer.compare(a[2], b[2]));

        // Calculate baseline MST weight
        int baseWeight = getMstWeight(n, sortedEdges, -1, -1);

        List<Integer> critical = new ArrayList<>();
        List<Integer> pseudoCritical = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int origIdx = sortedEdges[i][3];

            // 1. Exclude edge i: if weight increases or disconnected, it's critical
            if (getMstWeight(n, sortedEdges, i, -1) > baseWeight) {
                critical.add(origIdx);
            }
            // 2. Force edge i: if total weight equals baseWeight, it's pseudo-critical
            else if (getMstWeight(n, sortedEdges, -1, i) == baseWeight) {
                pseudoCritical.add(origIdx);
            }
        }

        return Arrays.asList(critical, pseudoCritical);
    }

    private int getMstWeight(int n, int[][] edges, int excludeIndex, int forceIndex) {
        DSU dsu = new DSU(n);
        int totalWeight = 0;
        int edgesCount = 0;

        // Force an edge into the tree if requested
        if (forceIndex != -1) {
            dsu.union(edges[forceIndex][0], edges[forceIndex][1]);
            totalWeight += edges[forceIndex][2];
            edgesCount++;
        }

        for (int i = 0; i < edges.length; i++) {
            if (i == excludeIndex)
                continue;

            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];

            if (dsu.find(u) != dsu.find(v)) {
                dsu.union(u, v);
                totalWeight += w;
                edgesCount++;
                if (edgesCount == n - 1)
                    break;
            }
        }

        // Graph is not fully connected
        if (edgesCount != n - 1)
            return Integer.MAX_VALUE;

        return totalWeight;
    }

    class DSU {
        int[] parent, rank;

        public DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int i) {
            if (parent[i] != i) {
                parent[i] = find(parent[i]);
            }
            return parent[i];
        }

        public void union(int x, int y) {
            int s1 = find(x);
            int s2 = find(y);
            if (s1 != s2) {
                if (rank[s1] < rank[s2]) {
                    parent[s1] = s2;
                } else if (rank[s1] > rank[s2]) {
                    parent[s2] = s1;
                } else {
                    parent[s2] = s1;
                    rank[s1]++;
                }
            }
        }
    }
}