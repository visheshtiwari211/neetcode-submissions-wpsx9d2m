class Node {
    int val;
    int key;
    Node prev;
    Node next;

    public Node(int key, int val) {
        this.val = val;
        this.key = key;
        this.prev = null;
        this.next = null;
    }
}

class LRUCache {
    int capacity;
    HashMap<Integer, Node> map;
    Node left, right;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        left = new Node(0,0);
        right = new Node(0,0);
        left.next = right;
        right.prev = left;
        
    }

    public void insert(Node n) {
        Node last = this.right.prev;
        last.next = n;
        n.prev = last;
        this.right.prev = n;
        n.next = right;
    }

    public void remove(Node n) {
        Node prev = n.prev;
        Node next = n.next;
        prev.next = next;
        next.prev = prev;
    }
    
    public int get(int key) {
        if(map.containsKey(key)) {
            Node n = map.get(key);
            remove(n);
            insert(n);
            return map.get(key).val;
        }

        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            Node n = map.get(key);
            remove(n);
            insert(n);
            n.val = value;
        } else {
            if(map.size()>= capacity) {
                Node n = this.left.next;
                map.remove(n.key);
                remove(n);
            }
                Node n = new Node(key, value);
                map.put(key, n);
                insert(n);
        }
    }
}
