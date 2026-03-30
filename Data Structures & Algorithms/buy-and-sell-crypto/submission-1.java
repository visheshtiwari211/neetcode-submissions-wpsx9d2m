class Solution {
    public int maxProfit(int[] prices) {
        int maxDiff = 0;

        for(int i =0; i<prices.length; i++) {
            int diff = 0;
            for(int j= i+ 1; j < prices.length; j++) {
                if(prices[j] > prices[i]) {
                    int tempDiff = prices[j] - prices[i];
                    diff = Math.max(diff, tempDiff);
                }
            }
            maxDiff = Math.max(maxDiff, diff);
        }

        return maxDiff;
    }
}
