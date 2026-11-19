class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0] == 1) return 0;
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        Integer[][] matrix = new Integer[m][n];
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1 || (i > 0 && matrix[i-1][0] == 0))
                matrix[i][0] = 0;
            else
                matrix[i][0] = 1;
        }

        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 1 || (i > 0 && matrix[0][i-1] == 0))
                matrix[0][i] = 0;
            else
                matrix[0][i] = 1;
        }

        return getUniquePaths(m, n, m - 1, n - 1, matrix, obstacleGrid);
    }

    public int getUniquePaths(
        int m, int n, int i, int j, Integer[][] matrix, int[][] obstacleGrid) {
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return 0;
        }
        if (matrix[i][j] != null)
            return matrix[i][j];
        if (obstacleGrid[i][j] == 1) {
            matrix[i][j] = 0;
            return 0;
        }
        int path = getUniquePaths(m, n, i - 1, j, matrix, obstacleGrid)
            + getUniquePaths(m, n, i, j - 1, matrix, obstacleGrid);
        matrix[i][j] = path;
        return path;
    }
}