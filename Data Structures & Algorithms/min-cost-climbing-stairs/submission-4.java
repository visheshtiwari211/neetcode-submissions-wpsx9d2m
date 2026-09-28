class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if(n == 2) return Math.min(cost[0], cost[1]);
        int first = 0;
        int second = 0;
        int curr = 0;

        for(int i = 2; i<=n; i++) {
            curr = Math.min(first + cost[i-2], second + cost[i-1]);
            first = second;
            second = curr;
        }
        return curr;
    }
}
