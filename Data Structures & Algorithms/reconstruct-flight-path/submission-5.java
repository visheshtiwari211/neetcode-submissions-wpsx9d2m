class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, List<String>> adj = new HashMap<>();
        Map<String, List<Boolean>> visited = new HashMap<>();
        for (int i = 0; i < tickets.size(); i++) {
            String from = tickets.get(i).get(0), to = tickets.get(i).get(1);
            if (adj.get(from) == null) {
                adj.put(from, new ArrayList<>());
            }
            if (visited.get(from) == null) {
                visited.put(from, new ArrayList<>());
            }
            adj.get(from).add(to);
            visited.get(from).add(false);
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
        Map<String, List<Boolean>> visited, List<String> seq, String from) {
            if(!adj.containsKey(from)) {
                seq.add(from);
                return;
            }
        List<String> airports = adj.get(from);
        List<Boolean> traversed = visited.get(from);
        for (int i = 0; i < airports.size(); i++) {
            if (traversed.get(i))
                continue;

            String airport = airports.get(i);
            traversed.set(i, true);
            getTickets(ticketSize, adj, visited, seq, airport);
        }
        seq.add(from);
        return;
    }
}
