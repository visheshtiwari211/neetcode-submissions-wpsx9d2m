class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        // memo[i] == true means index i cannot lead to a valid segmentation
        boolean[] failed = new boolean[s.length()];
        return canBreak(s, dict, 0, failed);
    }

    private boolean canBreak(String s, Set<String> dict, int start, boolean[] failed) {
        if (start == s.length()) {
            return true;
        }

        // If we already know this index cannot segment successfully, prune early
        if (failed[start]) {
            return false;
        }

        for (int end = start + 1; end <= s.length(); end++) {
            String sub = s.substring(start, end);
            if (dict.contains(sub) && canBreak(s, dict, end, failed)) {
                return true;
            }
        }

        // Mark this starting index as unable to form valid words
        failed[start] = true;
        return false;
    }
}