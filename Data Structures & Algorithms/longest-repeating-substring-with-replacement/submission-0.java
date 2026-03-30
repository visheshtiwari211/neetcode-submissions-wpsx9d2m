class Solution {
    public int characterReplacement(String s, int k) {
        int l= 0, r= 0, mct = 0, len = 0;
        int[] freq = new int[26];

        while(r<s.length()) {
            freq[s.charAt(r) - 'A']++;
            mct = getMaxFreq(freq);
            while((r-l+1) - mct > k) {
                freq[s.charAt(l)- 'A']--;
                l++;
            } 
            len = Math.max(r-l+1, len);
            r++;
        }
        return len;
    }
}

// Helper: recompute max frequency in current window
private int getMaxFreq(int[] freq) {
    int mct = 0;
    for (int f : freq) {
        mct = Math.max(mct, f);
    }
    return mct;
}
