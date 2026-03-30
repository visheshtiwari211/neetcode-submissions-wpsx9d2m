class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        Queue<Integer> q = new LinkedList<>();
        int r = 0;
        while(r<arr.length) {
            if(q.size() < k) {
                q.add(arr[r]);
            } else {
                if(Math.abs(arr[r] - x) < Math.abs(q.peek() - x)) {
                    q.poll();
                    q.add(arr[r]);
                }
            }
            
            r++;
        }

        return new ArrayList(q);
    }
}