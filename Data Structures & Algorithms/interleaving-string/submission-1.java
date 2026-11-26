class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        Boolean[][][] memo =new Boolean[s1.length() + 1][s2.length() + 1][2];
        return possible(s1, s2, s3, 0, 0, 0, 0, memo) || possible(s1, s2, s3, 0, 0, 0, 1, memo);
    }

    public boolean possible(String s1, String s2, String s3, int i, int j, int k, int from, Boolean[][][] memo) {
        // Base case: all three strings completely matched
        if (i == s1.length() && j == s2.length() && k == s3.length()) {
            return true;
        }
        if(memo[i][j][from] != null) return memo[i][j][from];

        if (from == 0) {
            for (int l = k + 1; l <= s3.length(); l++) {
                String left = s3.substring(k, l);
                if (s1.startsWith(left, i)) {
                    if (possible(s1, s2, s3, i + left.length(), j, l, 1, memo)) {
                        memo[i][j][from] = true;
                        return true;
                    }
                } else {
                    break; // Optimization: if a shorter prefix doesn't match, longer ones won't
                           // either
                }
            }
        } else {
            for (int l = k + 1; l <= s3.length(); l++) {
                String left = s3.substring(k, l);
                if (s2.startsWith(left, j)) {
                    if (possible(s1, s2, s3, i, j + left.length(), l, 0, memo)) {
                        memo[i][j][from] = true;
                        return true;
                    }
                } else {
                    break;
                }
            }
        }
        memo[i][j][from] = false;
        return false;
    }
}
