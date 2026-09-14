class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Node>> adj = new ArrayList<>();
        int m = flights.length; 
        
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int from = flights[i][0], to = flights[i][1], price = flights[i][2];
            adj.get(from).add(new Node(to, price));
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        Queue<int[]> q2 = new LinkedList<>();
        q2.add(new int[]{0, src, 0}); //stops, current_city, price accumulated
        
        while (!q2.isEmpty()) {
            int[] node = q2.poll();
            int stops = node[0], city = node[1], price = node[2];
            if(stops >= k + 1) continue;
            for (Node edge : adj.get(city)) {
                int neigh = edge.index();
                int price2 = edge.weight();
                if (price + price2 < dist[neigh]) {
                    dist[neigh] = price + price2;
                    q2.add(new int[]{stops + 1, neigh, dist[neigh]});
                }
            }
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }

    public static class Node {
        private final int index;
        private final int weight;

        public Node(int index, int weight) {
            this.index = index;
            this.weight = weight;
        }

        public int index() {
            return index;
        }

        public int weight() {
            return weight;
        }
    }
}