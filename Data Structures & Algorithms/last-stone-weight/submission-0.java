class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones.length == 1) {
            return stones[0];
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)-> b-a);
        for(int stone: stones) {
            queue.add(stone);
        }

        while(queue.size() > 1) {
            int greatest = queue.poll();
            int secondgreatest = queue.poll();
            int diff = greatest - secondgreatest;
            if(diff > 0) {
                queue.add(diff);
            }
        }
        if(queue.size() == 1) {
            return queue.poll();
        } 
        return 0;
    }
}
