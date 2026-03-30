class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap();
        for(int a: nums) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((a,b) -> a.getValue() - b.getValue());
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            minHeap.offer(entry);
            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[] arr = new int[k];
        int i = 0;

        while(!minHeap.isEmpty()) {
            Map.Entry<Integer, Integer> entry = minHeap.poll();
            arr[i] = entry.getKey();
            i++;
        }

        return arr;
    }
}
