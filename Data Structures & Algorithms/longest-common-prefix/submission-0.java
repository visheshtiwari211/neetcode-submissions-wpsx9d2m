class Solution {
    public String longestCommonPrefix(String[] strs) {
        String longPre = strs[0];
        for(int i = 1; i<strs.length; i++) {
            int commonPre = 0;
            int smallestLength = Math.min(strs[i].length(), longPre.length());
            int j = 0;
            while(j < smallestLength) {
                if(strs[i].charAt(j) != longPre.charAt(j)) {
                    break;
                } else {
                    commonPre++;
                }
                j++;
            }
            longPre = longPre.substring(0, commonPre);
        }

        return longPre;
    }
}