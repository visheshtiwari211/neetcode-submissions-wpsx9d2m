class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> 
        Integer.compare(
            a[0] * a[0] + a[1] * a[1],
            b[0] * b[0] + b[1] * b[1]
        )
        );
        int[][] ans = new int[k][2];
        for(int[] point : points) {
            queue.add(point);
        }
        int i = 0;
        while(i < k && !queue.isEmpty()) {
            ans[i] = queue.poll();
            i++;
        }

        return ans;
    }
}
