class Solution {
    public boolean isPalindrome(String s) {
        char[] array = new char[s.length()];
        int k = 0;

        for(int i = 0; i< s.length(); i++) {
            char m = s.charAt(i);
            if(Character.isLetterOrDigit(m)) {
                array[k++] = Character.toLowerCase(m);
            }
        }

        int i = 0, l = k - 1;

        while(i < l) {
            if(array[i] != array[l]) {
                return false;
            }
            i++;
            l--;
        }

        return true;

    }
}
