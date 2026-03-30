class LRUCache {
    int cap;
    HashMap<Integer, Integer> map;
    LinkedList<Integer> ll;
    public LRUCache(int capacity) {
        cap = capacity;
        map = new HashMap<>();
        ll = new LinkedList<>();
    }
    
    public int get(int key) {
        if(map.containsKey(key)) {
            ll.removeFirstOccurrence(key);
            ll.add(key);
            return map.get(key);
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            ll.remove((Integer)key);
        }
        map.put(key, value);
        ll.add(key);
        while(ll.size() > cap) {
            int mapKey = ll.getFirst();
            map.remove(mapKey);
            ll.removeFirst();
        }
    }
}
