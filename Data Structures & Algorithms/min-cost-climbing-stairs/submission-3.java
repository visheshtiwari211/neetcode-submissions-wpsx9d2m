class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if(n == 2) return Math.min(cost[0], cost[1]);
        int[] dp = new int[n];
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

    public int getmin(int[] cost, int[] dp, int n, int i) {
        if (i >= n)
            return 0;

        int minCost = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        dp[i] = minCost;
        getmin(cost, dp, n, i + 1);
        return Math.min(dp[n - 1] + cost[n - 1], dp[n - 2] + cost[n - 2]);
    }
}
