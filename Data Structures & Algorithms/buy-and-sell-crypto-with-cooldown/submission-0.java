class Solution {
    public int maxProfit(int[] prices) {
        Integer[][] memo = new Integer[prices.length][3];
        getMaxProfit(0, prices, 0, memo);
        return memo[0][0];
    }

    public int getMaxProfit(int i, int[] prices, int action, Integer[][] memo) {
        if (i >= prices.length)
            return 0;
        if (memo[i][action] != null)
            return memo[i][action];

        int profit = 0;
        if (action == 0) {
            profit = Math.max(getMaxProfit(i + 1, prices, 1, memo) - prices[i],
                getMaxProfit(i + 1, prices, 0, memo));
            memo[i][action] = profit;
        } else if (action == 1) {
            profit = Math.max(
                getMaxProfit(i + 1, prices, 2, memo) + prices[i], getMaxProfit(i + 1, prices, 1, memo));
            memo[i][action] = profit;
        } else {
            profit = getMaxProfit(i + 1, prices, 0, memo);
            memo[i][action] = profit;
        }

        return profit;
    }
}
