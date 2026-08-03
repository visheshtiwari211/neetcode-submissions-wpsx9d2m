class Solution {
    HashMap<Integer, List<Integer>> hashmap = new HashMap<>();
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
            hashmap.put(i, new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            adj.get(prerequisite[1]).add(prerequisite[0]);
        }

        Level[] visited = new Level[numCourses];
        for (int i = 0; i < numCourses; i++) {
            visited[i] = Level.UNVISITED;
        }
        for(int i = 0; i < numCourses; i++) {
            dfs(adj.get(i), visited, i, adj);
        }
        List<Boolean> result = new ArrayList<>();
        for(int i = 0; i < queries.length; i++) {
            List<Integer> l = hashmap.get(queries[i][1]);
            if(l != null && l.contains(queries[i][0])) result.add(true); else result.add(false);
        }

        return result;
        
    }

    public void dfs(List<Integer> state, Level[] visited, int i, List<List<Integer>> adj) {
        if(visited[i] == Level.DONE) return;
        visited[i] = Level.VISITING;
        for(int neighbor : state) {
            dfs(adj.get(neighbor), visited, neighbor, adj);
            for(int trans : hashmap.get(neighbor)) {
                if(!hashmap.get(i).contains(trans)) hashmap.get(i).add(trans);
            }
            if(!hashmap.get(i).contains(neighbor)) hashmap.get(i).add(neighbor);
        }
        visited[i] = Level.DONE;
        return;
    }

    enum Level {
        DONE, VISITING, UNVISITED
    }
}