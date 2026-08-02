class Solution {
    HashSet<Integer> noEVisited = new HashSet<>();
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        Level[] visited = new Level[n];
        for (int i = 0; i < n; i++) {
            visited[i] = Level.UNVISITED;
        }
        for(int i =0; i<adj.size(); i++) {
            if(visited[i] == Level.UNVISITED) {
                Boolean f = dfs(adj.get(i), visited, i, adj, i);
                if(!f) return false;
            }
        }

        if(noEVisited.size() == n) return true; else return false; 
    }

    public boolean dfs(List<Integer> state, Level[] visited, int i, List<List<Integer>> adj, int pred) {
        if(visited[i] == Level.DONE) return true;
        if(visited[i] == Level.VISITING) return false;
        visited[i] = Level.VISITING;
        noEVisited.add(i);
        for(int j = 0; j<state.size(); j++) {
            if(state.get(j) != pred) {
                Boolean ans = dfs(adj.get(state.get(j)), visited, state.get(j), adj, i);
            if(!ans) return false;
            }
        }
        visited[i] = Level.DONE;
        return true;
    }

    enum Level {
        DONE, VISITING, UNVISITED
    }
}
