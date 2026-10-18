class Solution {
    public int countSubstrings(String s) {
        if (s == null || s.length() < 2) return 1;
        int n = s.length();

        int maxLen = 0;
        int bestStart = 0, count = 0;
        boolean[][] dp = new boolean[n][n];

        for (int i = n-1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if(s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 2 || dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                    }
                }
                if (dp[i][j]) {
                    count++;
                }
            }
        }

        return count;
    }
}
