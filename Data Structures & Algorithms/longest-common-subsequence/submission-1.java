class Solution {
    Integer[][] arr; 
    public int longestCommonSubsequence(String text1, String text2) {
        arr = new Integer[text1.length()][text2.length()];
        return findLCS(text1, text2, 0, 0);
    }

    public int findLCS(String text1, String text2, int i, int j) {
        if(i >= text1.length() || j>=text2.length()) {
            return 0;
        }
        if(arr[i][j] != null) {
            return arr[i][j];
        }
        if(text1.charAt(i) == text2.charAt(j)) {
            return 1 + findLCS(text1, text2, i + 1, j+1);
        }

        return arr[i][j] = Math.max(findLCS(text1, text2, i+1, j), findLCS(text1, text2, i, j+1));
    }
}
