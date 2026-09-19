class Solution {
    enum Level { UNVISITED, VISITING, VISITED }
    ;
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        HashMap<Integer, List<Integer>> rMap = new HashMap<>();
        List<Level> rVisited = new ArrayList<>(Collections.nCopies(k + 1, Level.UNVISITED));

        for (int i = 1; i <= k; i++) {
            rMap.put(i, new ArrayList<>());
        }

        for (int[] edge : rowConditions) {
            rMap.get(edge[0]).add(edge[1]);
        }

        Stack<Integer> rowS = new Stack<>();
        int[] rowI = new int[k];
        for (int i = 1; i <= k; i++) {
            if (!dfs(rMap, rVisited, i, rowS)) {
                return new int[0][0];
            }
        }

        int i = 0;
        while (!rowS.isEmpty() && i < k) {
            rowI[i] = rowS.pop();
            i++;
        }

        HashMap<Integer, List<Integer>> cMap = new HashMap<>();
        List<Level> cVisited = new ArrayList<>(Collections.nCopies(k + 1, Level.UNVISITED));

        for (i = 1; i <= k; i++) {
            cMap.put(i, new ArrayList<>());
        }

        for (int[] edge : colConditions) {
            cMap.get(edge[0]).add(edge[1]);
        }

        Stack<Integer> colS = new Stack<>();
        int[] colI = new int[k];
        for (i = 1; i <= k; i++) {
            if (!dfs(cMap, cVisited, i, colS)) {
                return new int[0][0];
            }
        }

        i = 0;
        while (!colS.isEmpty() && i < k) {
            colI[i] = colS.pop();
            i++;
        }

        HashMap<Integer, List<Integer>> map2 = new HashMap<>();
        for (i = 1; i <= k; i++) {
            map2.put(i, new ArrayList<>());
        }

        // Store [rowIndex, colIndex] for each value
        for (i = 0; i < k; i++) {
            map2.get(rowI[i]).add(i);
        }
        for (i = 0; i < k; i++) {
            map2.get(colI[i]).add(i);
        }

        // --- 4. BUILD FINAL MATRIX ---
        int[][] finalMat = new int[k][k];
        for (int key : map2.keySet()) {
            List<Integer> indexL = map2.get(key);
            int rI = indexL.get(0);
            int cI = indexL.get(1);
            finalMat[rI][cI] = key;
        }

        return finalMat;
    }

    public boolean dfs(
        HashMap<Integer, List<Integer>> map, List<Level> visited, int i, Stack<Integer> st) {
        if (visited.get(i) == Level.VISITING)
            return false;
        if (visited.get(i) == Level.VISITED)
            return true;

        visited.set(i, Level.VISITING);
        List<Integer> l1 = map.get(i);
        for (int j = 0; j < l1.size(); j++) {
            if (!dfs(map, visited, l1.get(j), st)) {
                return false;
            }
        }

        st.push(i);
        visited.set(i, Level.VISITED);
        return true;
    }
}