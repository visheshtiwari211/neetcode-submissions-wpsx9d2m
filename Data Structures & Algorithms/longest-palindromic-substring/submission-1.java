class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) return s;
        int n = s.length();

        int maxLen = 0;
        int bestStart = 0;
        boolean[][] dp = new boolean[n][n];

        for (int i = n-1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if(s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 2 || dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                    }
                }
                if (dp[i][j]) {
                    int len = j - i + 1;
                    if (len > maxLen) {
                        maxLen = len;
                        bestStart = i;
                    }
                }
            }
        }

        return s.substring(bestStart, bestStart + maxLen);
    }
}