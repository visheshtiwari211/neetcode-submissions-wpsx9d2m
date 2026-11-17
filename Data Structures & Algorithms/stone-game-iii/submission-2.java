class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        Integer[] leadArr = new Integer[stoneValue.length];
        int dp1 = 0, dp2 = 0, dp3 = 0;

        for (int i = n - 1; i >= 0; i--) {
            // Choice 1: Take 1 stone
            int best = stoneValue[i] - dp1;

            // Choice 2: Take 2 stones (if within bounds)
            if (i + 1 < n) {
                best = Math.max(best, stoneValue[i] + stoneValue[i + 1] - dp2);
            }

            // Choice 3: Take 3 stones (if within bounds)
            if (i + 2 < n) {
                best = Math.max(best, stoneValue[i] + stoneValue[i + 1] + stoneValue[i + 2] - dp3);
            }

            // Shift the rolling window left by 1
            dp3 = dp2;
            dp2 = dp1;
            dp1 = best;
        }

        // At the end of the loop, dp1 holds lead[0]
        if (dp1 > 0) return "Alice";
        if (dp1 < 0) return "Bob";
        return "Tie";
    }
}