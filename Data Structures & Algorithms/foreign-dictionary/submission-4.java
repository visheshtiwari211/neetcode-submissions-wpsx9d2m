class Solution {
    public String foreignDictionary(String[] words) {
        Map<Character, List<Character>> map = new HashMap<>();
        int[] inorder = new int[26];
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                Character ch = words[i].charAt(j);
                if (!map.containsKey(ch)) {
                    map.put(ch, new ArrayList());
                }
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            int j = 0;
            while (j < words[i].length() && j < words[i + 1].length()) {
                if (words[i].charAt(j) != words[i + 1].charAt(j)) {
                    map.get(words[i].charAt(j)).add(words[i + 1].charAt(j));
                    inorder[words[i+1].charAt(j) - 'a']++;
                    break;
                }
                j++;
            }

            if (words[i].length() > words[i + 1].length() && words[i].startsWith(words[i + 1]))
                return "";
        }

        Queue<Character> q = new LinkedList();
        for(int i = 0 ; i<inorder.length; i++) {
            Character a = (char) ('a' + i);
            if(inorder[i] == 0 && map.containsKey(a)) {
                q.add(a);
            }
        }
        int count = 0;
        StringBuilder sb = new StringBuilder("");
        while(!q.isEmpty()) {
            Character ch = q.poll();
            sb.append(ch);
            count++;
            for(Character c: map.get(ch)) {
                inorder[c - 'a']--;
                if(inorder[c - 'a'] == 0) {
                    q.add(c);
                }
            }
        }

        if(count != map.keySet().size()) return "";
        return sb.toString();
    }
}
