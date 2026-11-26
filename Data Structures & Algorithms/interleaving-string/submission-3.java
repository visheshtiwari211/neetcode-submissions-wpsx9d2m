class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length())
            return false;
        Boolean[][] memo = new Boolean[s1.length() + 1][s2.length() + 1];
        return getAns(s1.length(), s2.length(), s1, s2, s3, memo);
    }

    public boolean getAns(int i, int j, String s1, String s2, String s3, Boolean[][] memo) {
        if (i == 0 && j == 0) {
            return true;
        }
        if (memo[i][j] != null)
            return memo[i][j];

        boolean ans = (i > 0 && getAns(i - 1, j, s1, s2, s3, memo) && s1.charAt(i - 1) == s3.charAt(i + j - 1))
            || (j > 0 && getAns(i, j - 1, s1, s2, s3, memo) && s2.charAt(j - 1) == s3.charAt(i + j - 1));

        memo[i][j] = ans;
        return ans;
    }
}
