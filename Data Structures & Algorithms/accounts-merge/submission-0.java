class Solution {
    public List<List<String>> accountsMerge(List<List<String>> acc) {
        HashMap<String, String> map = new HashMap();
        HashMap<String, String> emailName = new HashMap();
        for(int i =0; i<acc.size(); i++) {
            for(int j = 1; j<acc.get(i).size(); j++) {
                if(!map.containsKey(acc.get(i).get(j))) {
                    map.put(acc.get(i).get(j), acc.get(i).get(j));
                }

                if(!emailName.containsKey(acc.get(i).get(j))) {
                    emailName.put(acc.get(i).get(j), acc.get(i).get(0));
                }
            }
        }

        for(int i =0; i<acc.size(); i++) {
            for(int j = 2; j<acc.get(i).size(); j++) {
                String firstRoot = find(acc.get(i).get(j-1), map);
                String secondRoot = find(acc.get(i).get(j), map);
                if(!firstRoot.equals(secondRoot)) {
                    map.put(firstRoot, secondRoot);
                }
            }
        }
        HashMap<String, List<String>> m1 = new HashMap();
        for(String email : map.keySet()) {
            String root = find(email, map);
            if(!m1.containsKey(root)) {
                m1.put(root, new ArrayList<>());
            }
            m1.get(root).add(email);
        }

        List<List<String>> l1 = new ArrayList<>();
        for(Map.Entry<String, List<String>> entry: m1.entrySet()) {
            String name = emailName.get(entry.getKey());
            List<String> emails = entry.getValue();
            Collections.sort(emails);
            List<String> f = new ArrayList<>();
            f.add(name);
            f.addAll(emails); 
            l1.add(f);
        }
        return l1;
    }

    public String find(String x, HashMap<String, String> map) {
        String curr = x;
        while (!curr.equals(map.get(curr))) {
            curr = map.get(curr);
        }
        return curr;
    }
}