class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if(n == 2) return Math.min(cost[0], cost[1]);
        int[] dp = new int[n];
        dp[0] = 0;
        dp[1] = 0;


        return getmin(cost, dp, n, 2);
    }

    public int getmin(int[] cost, int[] dp, int n, int i) {
        if (i == n - 1) {
            return Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2] + cost[i]);
        }
        if (i >= n)
            return 0;

        int minCost = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        dp[i] = minCost;
        
        return getmin(cost, dp, n, i + 1);
    }
}
