class Solution {
    public int change(int amount, int[] coins) {
        if(amount == 0) {
            return 1;
        }
        Integer[][] memo = new Integer[amount + 1][coins.length + 1];
        memo[0][0] = 0;
        int nWays = 0;
        for (int i = 0; i < coins.length; i++) {
            nWays += getWays(amount - coins[i], coins, memo, i);
        }
        return nWays;
    }

    public int getWays(int amountLeft, int[] coins, Integer[][] memo, int k) {
        if (k >= coins.length)
            return 0;
        if (amountLeft < 0)
            return 0;
        if (amountLeft == 0)
            return 1;

        if (memo[amountLeft][k + 1] != null)
            return memo[amountLeft][k + 1];

        int ways = 0;
        for (int i = k; i < coins.length; i++) {
            ways += getWays(amountLeft - coins[i], coins, memo, i);
        }
        memo[amountLeft][k + 1] = ways;
        return ways;
    }
}
