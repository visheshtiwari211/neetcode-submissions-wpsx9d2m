class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length()) return "";
        Map<Character, Integer> countT = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for(int i = 0; i<t.length(); i++) {
            countT.put(t.charAt(i), countT.getOrDefault(t.charAt(i), 0) + 1);
        }

        int l = 0, have = 0, need = countT.size(), strLen = Integer.MAX_VALUE;
        int[] arr = {-1, -1};

        for(int r =0; r< s.length(); r++) {
            char c = s.charAt(r);
            window.put(c, window.getOrDefault(c, 0) + 1);
            if(countT.containsKey(c) && countT.get(c).equals(window.get(c))) {
                have++;
            }

            while(have == need) {
                if(r-l + 1 < strLen) {
                    strLen = r-l+1;
                    arr[0] = l;
                    arr[1] = r;
                }
                char left = s.charAt(l);
                window.put(left, window.get(left) - 1);
                if(countT.containsKey(left) && window.get(left) < countT.get(left)) {
                    have--;
                }
                l++;
            }
        }

        if(strLen == Integer.MAX_VALUE) return ""; else return s.substring(arr[0], arr[1] + 1);

    }
}
