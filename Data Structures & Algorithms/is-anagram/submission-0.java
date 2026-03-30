class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> firstMap = new HashMap<>();
        HashMap<Character, Integer> secondMap = new HashMap<>();

        for (int i =0 ; i<s.length(); i++) {
            firstMap.put(s.charAt(i), firstMap.getOrDefault(s.charAt(i), 0) + 1);
            secondMap.put(t.charAt(i), secondMap.getOrDefault(t.charAt(i), 0) + 1);
        }

        return firstMap.equals(secondMap);
    }
}
