class KthLargest {
    PriorityQueue<Integer> queue = new PriorityQueue<>();
    int le;
    public KthLargest(int k, int[] nums) {
        le = k;
        for(int num: nums) {
            queue.add(num);
            if(queue.size() > k) {
                queue.poll();
            }
        }
    }
    
    public int add(int val) {
        queue.add(val);
        while(queue.size() > le) {
            queue.poll();
        }

        return queue.peek();
    }
}
