class Solution {
    public int leastInterval(char[] tasks, int n) {
        int totalCycle = 0;
        HashMap<Character, Integer> map = new HashMap();
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for(char task: tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }
        queue.addAll(map.values());

        while(!queue.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int localCycle = 0;
            while(localCycle <= n) {
                if(!queue.isEmpty()) {
                int freq = queue.poll();
                freq--;
                if(freq > 0) {
                    temp.add(freq);
                }
                }
                localCycle++;
                totalCycle++;

                if(queue.isEmpty() && temp.isEmpty()) {
                    break;
                }
            }
            queue.addAll(temp);
        }

        return totalCycle;
    }        
}
