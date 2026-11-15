class Solution {
    public int integerBreak(int n) {
        Integer[] memo = new Integer[n + 1];
        return prod(n, memo);
    }

    public int prod(int n, Integer[] memo) {
        if(n == 1) return 0;
        if(n == 2) return 1;
        if(memo[n] != null) return memo[n];

        int maxProd = Integer.MIN_VALUE;
        for(int i = 1; i<n; i++) {
            int prod = Math.max(i * (n-i), i * prod(n-i, memo));
            maxProd = Math.max(prod, maxProd);
        } 
        memo[n] = maxProd;
        return maxProd;
    }
}