class Solution {
    public int minimumEffortPath(int[][] heights) {
        List<int[]> flattened = new ArrayList<>();
        int rows = heights.length, cols = heights[0].length;
        if (rows == 1 && cols == 1)
            return 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int current = j + i * cols;
                if (j + 1 < cols) {
                    int right = j + 1 + i * cols;
                    int weight = Math.abs(heights[i][j] - heights[i][j + 1]);
                    flattened.add(new int[] {current, right, weight});
                }
                if (i + 1 < rows) {
                    int down = j + (i + 1) * cols;
                    int weight = Math.abs(heights[i][j] - heights[i + 1][j]);
                    flattened.add(new int[] {current, down, weight});
                }
            }
        }

        flattened.sort((a, b) -> Integer.compare(a[2], b[2]));

        int[] parent = new int[rows * cols];
        for (int i = 0; i < rows * cols; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < flattened.size(); i++) {
            int node1 = flattened.get(i)[0];
            int root1 = find(parent, node1);
            int node2 = flattened.get(i)[1];
            int root2 = find(parent, node2);
            if (root1 != root2) {
                parent[root1] = root2;
            }

            if (find(parent, 0) == find(parent, rows * cols - 1)) {
                return flattened.get(i)[2];
            }
        }

        return 0;
    }

    public int find(int[] parent, int indx) {
        if (parent[indx] == indx)
            return indx;
        return parent[indx] = find(parent, parent[indx]);
    }
}