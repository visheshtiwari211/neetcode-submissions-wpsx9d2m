class Solution {
    private List<String> l1 = new ArrayList();
    public List<String> letterCombinations(String digits) {
        if(digits.length() <= 0) return new ArrayList();
        String[] digitsToChar = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        getComb(digits, digitsToChar, 0, new StringBuilder());
        return l1;
    }

    public void getComb(String digits, String[] digitsToChar, int curr, StringBuilder currStr) {
        if(curr >= digits.length()) {
            l1.add(currStr.toString());
            return;
        }

        String s = digitsToChar[digits.charAt(curr) - '0'];
        for(int i = 0; i < s.length(); i++) {
            currStr.append(s.charAt(i));
            getComb(digits, digitsToChar, curr + 1, currStr);
            if(currStr.length() > 0) {
                currStr.deleteCharAt(currStr.length() - 1);
            }
        }
    }
}
