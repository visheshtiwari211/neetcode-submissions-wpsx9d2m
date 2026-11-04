class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wDict = new HashSet<>(wordDict);
        boolean[] computed = new boolean[s.length()];
        HashMap<Integer, Boolean> cache = new HashMap<>();
        return canBreak(s, wDict, 0, computed, cache);
    }

    public boolean canBreak(
        String s, Set<String> wDict, int i, boolean[] computed, HashMap<Integer, Boolean> cache) {
        if (i >= s.length()) {
            return true;
        }

        for (int j = i + 1; j <= s.length(); j++) {
            String sub = s.substring(i, j);
            if (wDict.contains(sub)) {
                if (computed[i]) {
                    if (cache.get(i) != null && cache.get(i)) {
                        return true;
                    }
                } else {
                    if (canBreak(s, wDict, j, computed, cache)) {
                        return true;
                    }
                }
            }
        }

        computed[i] = true;
        cache.put(i, false);

        return false;
    }
}
