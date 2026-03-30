class Solution {
    public int maxProfit(int[] prices) {
        int l = 0, r =1;

        int maxProfit = 0;

        while(r < prices.length) {
            if(prices[r] > prices[l]) {
                int profit = prices[r] - prices[l];
                maxProfit = Math.max(maxProfit, profit);
            } else {
                l = r;
            }
            r++;
        }

        return maxProfit;
    }
}
