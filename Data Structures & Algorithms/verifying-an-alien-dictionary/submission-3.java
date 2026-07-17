class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i<order.length(); i++) {
            map.put(order.charAt(i), i);
        }
        int i = 0;
        while(i < words.length - 1) {
            int j = i + 1;
            int k = 0;
            while(k < words[i].length()) {
                if(k >= words[j].length()) return false;
                if(map.get(words[i].charAt(k)) > map.get(words[j].charAt(k))) return false;
                if(map.get(words[i].charAt(k)) < map.get(words[j].charAt(k))) break;

                k++;
            }
            i++;
        }

        return true;
    }
}