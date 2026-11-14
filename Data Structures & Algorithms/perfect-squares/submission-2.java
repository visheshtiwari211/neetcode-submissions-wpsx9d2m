class Solution {
    public int numSquares(int n) {
        Integer[] memo = new Integer[n + 1];
        return getCount(n, memo);
    }

    public int getCount(int n, Integer[] memo) {
        if(n == 0) return 0;
        if(n == 1) return 1;

        if(memo[n] != null) return memo[n];

        int num = (int) Math.sqrt(n);
        int smallestNum = Integer.MAX_VALUE;
        for(int i = num; i >=1; i--) {
            smallestNum = Math.min(getCount(n - (i * i), memo), smallestNum);
        }
        memo[n] = 1 + smallestNum;
        return 1 + smallestNum;
    }
}