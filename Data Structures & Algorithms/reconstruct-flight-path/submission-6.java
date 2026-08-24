class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, List<String>> adj = new HashMap<>();
        Map<String, Integer> visited = new HashMap<>();
        for (int i = 0; i < tickets.size(); i++) {
            String from = tickets.get(i).get(0), to = tickets.get(i).get(1);
            if (adj.get(from) == null) {
                adj.put(from, new ArrayList<>());
            }
            if (visited.get(from) == null) {
                visited.put(from, 0);
            }
            adj.get(from).add(to);
        }
        for (List<String> destinations : adj.values()) {
            Collections.sort(destinations);
        }
        List<String> seq = new ArrayList<>();
        getTickets(tickets.size(), adj, visited, seq, "JFK");
        Collections.reverse(seq);
        return seq;
    }

    public void getTickets(int ticketSize, Map<String, List<String>> adj,
        Map<String, Integer> visited, List<String> seq, String from) {
        if (!adj.containsKey(from)) {
            seq.add(from);
            return;
        }
        List<String> airports = adj.get(from);
        int i = visited.get(from);
        while (i < airports.size()) {
            String airport = airports.get(i);
            visited.put(from, i + 1);
            getTickets(ticketSize, adj, visited, seq, airport);
            i = visited.get(from);
        }
        seq.add(from);
        return;
    }
}
