class Solution {
    Set<Integer> cycleNodes = new HashSet<>();
    int cycleStart = -1;
    public int[] findRedundantConnection(int[][] edges) {
        int numCourses = edges.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[numCourses + 1];
        int[] parent = new int[numCourses + 1];
        findCycleDFS(1, 0, adj, visited, parent);
        for (int i = edges.length - 1; i >= 0; i--) {
            if (cycleNodes.contains(edges[i][0]) && cycleNodes.contains(edges[i][1])) {
                return edges[i];
            }
        }
        return new int[2];
    }

    private boolean findCycleDFS(
        int curr, int p, List<List<Integer>> adj, boolean[] visited, int[] parent) {
        visited[curr] = true;
        parent[curr] = p;
        for (int neighbor : adj.get(curr)) {
            if (neighbor == p)
                continue; // Skip the immediate parent edge

            if (visited[neighbor]) {
                // Cycle detected: backtrack from 'curr' to 'neighbor' using 'parent' array
                cycleStart = neighbor;
                int node = curr;
                while (node != neighbor) {
                    cycleNodes.add(node);
                    node = parent[node];
                }
                cycleNodes.add(neighbor);
                return true;
            }

            if (findCycleDFS(neighbor, curr, adj, visited, parent)) {
                return true;
            }
        }
        return false;
    }
}
