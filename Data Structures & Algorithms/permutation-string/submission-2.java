class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> map1 = new HashMap<>();
        for(char c: s1.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }

        int i = 0, j = i + s1.length() - 1;
        while(j < s2.length()) {
            HashMap<Character, Integer> map2 = new HashMap<>();
            String s = s2.substring(i, j + 1);
            for(char c: s.toCharArray()) {
                map2.put(c, map2.getOrDefault(c, 0) + 1);
            }

            if(map2.equals(map1)) {
                return true;
            }
            i++;
            j++;
        }

        return false;
    }
}
