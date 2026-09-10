class Solution {
    public String foreignDictionary(String[] words) {
        HashMap<Character, List<Character>> map = new HashMap<>();
        HashMap<Character, Level> visited = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                if (!map.containsKey(words[i].charAt(j))) {
                    map.put(words[i].charAt(j), new ArrayList<>());
                    visited.put(words[i].charAt(j), Level.UNVISITED);
                }
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            int k = 0;
            while (k < words[i].length() && k < words[i + 1].length()) {
                if (words[i].charAt(k) != words[i + 1].charAt(k)) {
                    map.get(words[i].charAt(k)).add(words[i + 1].charAt(k));
                    break;
                }
                k++;
            }
            if (words[i].length() > words[i + 1].length() && words[i].startsWith(words[i + 1])) {
                return "";
            }
        }

        String s = "";
        StringBuilder sb = new StringBuilder(s);
        for (Character c : map.keySet()) {
            List<Character> l1 = map.get(c);
            if (visited.get(c) == Level.VISITED)
                continue;
            visited.put(c, Level.VISITING);
            for (int i = 0; i < l1.size(); i++) {
                Character d = l1.get(i);
                if (!dfs(d, visited, map, s, sb)) {
                    return "";
                }
            }
            visited.put(c, Level.VISITED);
            sb.append(c);
        }
        return sb.reverse().toString();
    }

    public boolean dfs(Character c, HashMap<Character, Level> visited,
        HashMap<Character, List<Character>> map, String s, StringBuilder sb) {
        if (visited.get(c) == Level.VISITING)
            return false;
        if (visited.get(c) == Level.VISITED)
            return true;

        visited.put(c, Level.VISITING);
        List<Character> l1 = map.get(c);
        for (int i = 0; i < l1.size(); i++) {
            Character d = l1.get(i);
            if (!dfs(d, visited, map, s, sb)) {
                return false;
            }
        }

        sb.append(c);
        visited.put(c, Level.VISITED);
        return true;
    }

    enum Level { VISITED, UNVISITED, VISITING }
}
