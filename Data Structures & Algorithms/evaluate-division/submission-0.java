class Solution {
    public double[] calcEquation(List<List<String>> eq, double[] values, List<List<String>> queries) {
        HashMap<String, HashMap<String, Double>> map = new HashMap();
        for(int i = 0; i<eq.size(); i++) {
            String first = eq.get(i).get(0), second = eq.get(i).get(1);
            if(!map.containsKey(first)) {
                map.put(first, new HashMap<>());
            }
            map.get(first).put(second, values[i]);

            if(!map.containsKey(second)) {
                map.put(second, new HashMap<>());
            }
            double secondV = 1/values[i];
            map.get(second).put(first, secondV);
        }
        double[] result = new double[queries.size()];
        for(int i = 0; i<queries.size(); i++) {
            result[i] = getResult(queries.get(i).get(0), queries.get(i).get(1), "",1.0, map, new HashSet<>());
        }
        return result;
    }

    public double getResult(String from, String to, String parent, double prod, HashMap<String, HashMap<String, Double>> map, Set<String> visited) {
        if(!map.containsKey(from) || !map.containsKey(to)) return -1.0;
        if(from.equals(to)) return prod;

        HashMap<String,Double> eq = map.get(from);
        visited.add(from);
        for(Map.Entry<String, Double> entry: eq.entrySet()) {
            if(visited.contains(entry.getKey())) continue;
            double res = getResult(entry.getKey(), to, from, prod * entry.getValue(), map, visited);
            if(res != -1.0) return res;
        }
        return -1.0;
    }
}
