class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> hashSet = new HashSet<>();
        int l = 0, maxLen = 0, r =0;

        while(r < s.length()) {
            while(hashSet.contains(s.charAt(r))) {
                hashSet.remove(s.charAt(l));
                l++;
            }
            hashSet.add(s.charAt(r));
            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }

        return maxLen;
    }
}
