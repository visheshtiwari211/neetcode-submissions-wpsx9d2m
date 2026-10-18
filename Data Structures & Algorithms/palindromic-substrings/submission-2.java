class Solution {
    public int countSubstrings(String s) {
        if (s == null || s.length() < 2) return 1;
        int n = s.length();

        int bestStart = 0, count = 0;
        int maxLen = 1;

        for (int i = 0; i < n; i++) {
            // t = 0 handles odd centers (i, i), t = 1 handles even centers (i, i + 1)
            for (int t = 0; t < 2; t++) {
                int left = i;
                int right = i + t;

                while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                    int len = right - left + 1;
                    count++;
                    left--;
                    right++;
                }
            }
        }

        return count;
    }
}
