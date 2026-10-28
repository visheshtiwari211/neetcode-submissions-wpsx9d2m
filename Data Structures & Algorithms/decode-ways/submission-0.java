class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n + 1];
        // Base cases
        dp[0] = 1; // Empty string base case for two-digit jumps
        dp[1] = 1; // Validated s.charAt(0) != '0' above
        for (int i = 2; i <= n; i++) {
            // Single-digit branch: checks character at index i - 1
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }

            // Two-digit branch: checks substring at [i - 2, i)
            int twoDigitVal = Integer.parseInt(s.substring(i - 2, i));
            if (twoDigitVal >= 10 && twoDigitVal <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }
}
