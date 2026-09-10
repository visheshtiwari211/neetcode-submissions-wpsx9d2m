class Solution {
    // VISITED: Fully processed, already appended to ordering
    // VISITING: Currently in active DFS recursion stack (used to catch cycles)
    // UNVISITED: Node not yet explored
    enum Level { VISITED, UNVISITED, VISITING }

    public String foreignDictionary(String[] words) {
        // map: Adjacency list storing directed edges (charA -> charB means charA precedes charB)
        // visited: Tracks DFS traversal state for each character
        HashMap<Character, List<Character>> map = new HashMap<>();
        HashMap<Character, Level> visited = new HashMap<>();

        // Step 1: Discover and initialize all unique characters from the input words
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                if (!map.containsKey(words[i].charAt(j))) {
                    map.put(words[i].charAt(j), new ArrayList<>());
                    visited.put(words[i].charAt(j), Level.UNVISITED);
                }
            }
        }

        // Step 2: Build directed edges by comparing adjacent pairs of words
        for (int i = 0; i < words.length - 1; i++) {
            int k = 0;
            // Find the first index where the characters differ
            while (k < words[i].length() && k < words[i + 1].length()) {
                if (words[i].charAt(k) != words[i + 1].charAt(k)) {
                    // words[i][k] must come before words[i + 1][k] in alphabetical order
                    map.get(words[i].charAt(k)).add(words[i + 1].charAt(k));
                    break; // Later characters in these two words give no ordering guarantees
                }
                k++;
            }

            // Prefix invalid check:
            // If word1 is strictly longer than word2 and starts with word2 (e.g., ["ape", "ap"]),
            // word2 should have appeared first in a valid lexicographical ordering.
            if (words[i].length() > words[i + 1].length() && words[i].startsWith(words[i + 1])) {
                return "";
            }
        }

        // Step 3: Run post-order DFS to perform topological sort across all components
        String s = "";
        StringBuilder sb = new StringBuilder(s);
        for (Character c : map.keySet()) {
            List<Character> l1 = map.get(c);
            if (visited.get(c) == Level.VISITED)
                continue;

            visited.put(c, Level.VISITING);
            for (int i = 0; i < l1.size(); i++) {
                Character d = l1.get(i);
                // If a cycle is detected down the line, no valid ordering exists
                if (!dfs(d, visited, map, s, sb)) {
                    return "";
                }
            }
            visited.put(c, Level.VISITED);
            sb.append(c);
        }

        // Post-order DFS yields nodes from dependents to dependencies; reverse to get correct order
        return sb.reverse().toString();
    }

    /**
     * Depth-First Search for topological sort and 3-color cycle detection.
     * Returns true if valid DAG; returns false if a cycle (back-edge) is encountered.
     */
    public boolean dfs(Character c, HashMap<Character, Level> visited,
        HashMap<Character, List<Character>> map, String s, StringBuilder sb) {
        // If we reach a node currently in the call stack, a directed cycle exists
        if (visited.get(c) == Level.VISITING)
            return false;
        // If already visited and appended, skip reprocessing
        if (visited.get(c) == Level.VISITED)
            return true;

        // Mark as actively visiting (gray)
        visited.put(c, Level.VISITING);
        List<Character> l1 = map.get(c);
        for (int i = 0; i < l1.size(); i++) {
            Character d = l1.get(i);
            if (!dfs(d, visited, map, s, sb)) {
                return false;
            }
        }

        // All outgoing edges from 'c' have completed; mark visited (black) and append to result
        sb.append(c);
        visited.put(c, Level.VISITED);
        return true;
    }
}