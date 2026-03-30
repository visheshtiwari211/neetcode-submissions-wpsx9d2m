class TimeMap {
    HashMap<String, HashMap<Integer, String>> map1;

    public TimeMap() {
          map1 = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map1.containsKey(key)) {
            map1.put(key, new HashMap<>());
        }
        map1.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        String ans = "";
        if(!map1.containsKey(key)) {
            return "";
        }
        int maxTs = Integer.MIN_VALUE;
        HashMap<Integer, String> map = map1.get(key);
        for(Map.Entry<Integer, String> m : map.entrySet()) {
            if(m.getKey() <= timestamp) {
                maxTs = Math.max(maxTs, m.getKey());
            }
        }
        if(maxTs == Integer.MIN_VALUE) {
            return "";
        } else {
            return map1.get(key).get(maxTs);
        }
    }
}
