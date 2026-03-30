class Solution {
    List<String> list = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        if(digits.length() > 0) {
            getLetterCombinations(0, digits, map, "");
        }
        return list;
    }

    public void getLetterCombinations(int i, String digits, Map<Character, String> map, String s) {
        if(i>=digits.length()) {
            list.add(s);
            return;
        }

        String s1 = map.get(digits.charAt(i));

        for(int j=0; j<s1.length(); j++) {
            s = s + s1.charAt(j);
            getLetterCombinations(i+1, digits, map, s);
            s = s.substring(0, s.length() - 1);
        }
    }
}
