class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Integer[][] matrix = new Integer[m][n];
        matrix[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            matrix[i][0] = grid[i][0] + matrix[i - 1][0];
        }

        for (int i = 1; i < n; i++) {
            matrix[0][i] = grid[0][i] + matrix[0][i - 1];
        }
        return getUniquePaths(m, n, m - 1, n - 1, matrix, grid);
    }

    public int getUniquePaths(int m, int n, int i, int j, Integer[][] matrix, int[][] grid) {
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return 0;
        }
        if (matrix[i][j] != null)
            return matrix[i][j];
        int path = Math.min(getUniquePaths(m, n, i - 1, j, matrix, grid),
                       getUniquePaths(m, n, i, j - 1, matrix, grid))
            + grid[i][j];
        matrix[i][j] = path;
        return path;
    }
}