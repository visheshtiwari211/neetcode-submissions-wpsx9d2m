class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) return 0;
        HashMap<String, List<String>> map = new HashMap<>();
        for(int i = 0; i<wordList.size(); i++) {
            List<String> comb = getCombinations(wordList.get(i));
            for(int j = 0; j<comb.size(); j++) {
                if(map.get(comb.get(j)) == null) map.put(comb.get(j), new ArrayList());
                map.get(comb.get(j)).add(wordList.get(i));
            }
        }
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        visited.add(beginWord);
        int jump = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                String word = q.poll();
                if(word.equals(endWord)) return jump;
                List<String> comb = getCombinations(word);
                for(String c: comb) {
                    if(map.get(c) != null) {
                        List<String> edges = map.get(c);
                        for(String edge: edges) {
                            if(!visited.contains(edge)) {
                                visited.add(edge);
                                q.add(edge);
                            }
                        }
                    }
                }
            }
            jump++;
        }

        return 0;
    }

    public List<String> getCombinations(String word) {
        List<String> l1 = new ArrayList<>();
        for(int i = 0; i<word.length(); i++) {
            StringBuilder sb = new StringBuilder(word);
            sb.setCharAt(i, '*');
            l1.add(sb.toString());
        }
        return l1;
    }
}
