class Solution {
    public String foreignDictionary(String[] words) {
        // map: Adjacency list representing the directed graph (charA -> list of chars that follow charA)
        Map<Character, List<Character>> map = new HashMap<>();
        // inorder: Array storing the in-degree (number of incoming edges) for each character ('a' through 'z')
        int[] inorder = new int[26];

        // Step 1: Collect all unique characters from the input words to form the graph vertices
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                Character ch = words[i].charAt(j);
                if (!map.containsKey(ch)) {
                    map.put(ch, new ArrayList<>());
                }
            }
        }

        // Step 2: Build directed edges by comparing adjacent words
        for (int i = 0; i < words.length - 1; i++) {
            int j = 0;
            // Find the first index where the two words differ
            while (j < words[i].length() && j < words[i + 1].length()) {
                if (words[i].charAt(j) != words[i + 1].charAt(j)) {
                    // words[i][j] lexicographically precedes words[i + 1][j]
                    map.get(words[i].charAt(j)).add(words[i + 1].charAt(j));
                    inorder[words[i + 1].charAt(j) - 'a']++;
                    break; // Later characters do not provide valid relative ordering
                }
                j++;
            }

            // Prefix invalidity check:
            // If word1 is strictly longer than word2 and word1 starts with word2 (e.g., ["ape", "ap"]),
            // word2 must appear before word1 in a valid dictionary. If not, the ordering is invalid.
            if (words[i].length() > words[i + 1].length() && words[i].startsWith(words[i + 1])) {
                return "";
            }
        }

        // Step 3: Initialize BFS queue with all existing characters that have an in-degree of 0 (no prerequisites)
        Queue<Character> q = new LinkedList<>();
        for (int i = 0; i < inorder.length; i++) {
            Character a = (char) ('a' + i);
            if (inorder[i] == 0 && map.containsKey(a)) {
                q.add(a);
            }
        }

        // Step 4: Process nodes via Kahn's algorithm (BFS for Topological Sort)
        int count = 0;
        StringBuilder sb = new StringBuilder("");
        while (!q.isEmpty()) {
            Character ch = q.poll();
            sb.append(ch);
            count++;

            // Decrement in-degree for all outgoing neighbors
            for (Character c : map.get(ch)) {
                inorder[c - 'a']--;
                // If in-degree reaches 0, all dependencies have been resolved
                if (inorder[c - 'a'] == 0) {
                    q.add(c);
                }
            }
        }

        // Step 5: Cycle detection
        // If the processed count doesn't match the total unique characters, a directed cycle exists
        if (count != map.keySet().size()) {
            return "";
        }

        return sb.toString();
    }
}