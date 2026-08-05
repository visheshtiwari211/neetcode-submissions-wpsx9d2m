class Solution {
    public int countComponents(int n, int[][] edges) {
        int count = 0;
        List<List<Integer>> adj = new ArrayList();
        for(int i = 0; i<n;i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] e: edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        Level[] visited = new Level[n];
        for (int i = 0; i < n; i++) {
            visited[i] = Level.UNVISITED;
        }

        for(int i = 0; i<adj.size(); i++) {
            if(visited[i] == Level.UNVISITED) {
                count++;
                dfs(adj.get(i), adj, visited, i);
            }
        }
        return count;
    }

    private void dfs(List<Integer> state, List<List<Integer>> adj, Level[] visited, int i) {
        if(visited[i] == Level.VISITED) return;
        visited[i] = Level.VISITED;
        for(int j = 0; j<state.size(); j++) {
            dfs(adj.get(state.get(j)), adj, visited, state.get(j));
        }

        return;
    }

    enum Level {
        VISITED, UNVISITED
    }
}
