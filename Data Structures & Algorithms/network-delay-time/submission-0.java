class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.weight));
        int[] dist = new int[n + 1];
java.util.Arrays.fill(dist, Integer.MAX_VALUE);
        boolean[] visited = new boolean[n + 1];
        List<List<Node>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i<times.length; i++) {
            int source = times[i][0], target = times[i][1], weight = times[i][2];
            adj.get(source).add(new Node(target, weight));
        }
        djikstra(pq, dist, visited, adj, k);
        int maxDelay = 0;
        for(int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1; // A node was unreachable
            }
            maxDelay = Math.max(maxDelay, dist[i]);
        }
        return maxDelay;
    }

    public void djikstra(
        PriorityQueue<Node> pq, int[] dist, boolean[] visited, List<List<Node>> adj, int start) {
        dist[start] = 0;
        pq.add(new Node(start, dist[start]));

        while(!pq.isEmpty()) {
            Node edge = pq.poll();
            int u = edge.target, d = edge.weight;
            if (visited[u])
                continue;
            visited[u] = true;
            for (int i = 0; i<adj.get(u).size(); i++) {
                Node node = adj.get(u).get(i);
                int v = node.target;
                int weight = node.weight;
                int newDist = weight + d;
                if (newDist < dist[v]) {
                    dist[v] = newDist;
                    pq.add(new Node(v, newDist));
                }
            }
        }
    }

    static class Node {
        int target, weight;

        public Node(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }
    }
}
