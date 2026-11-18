class Solution {
    public int uniquePaths(int m, int n) {
        Integer[][] matrix = new Integer[m][n];
        for(int i = 0; i < m; i++) {
            matrix[i][0] = 1;
        }

        for(int i = 0; i < n; i++) {
            matrix[0][i] = 1;
        }

        return getUniquePaths(m,n, m-1, n-1, matrix);
    }

    public int getUniquePaths(int m, int n, int i, int j, Integer[][] matrix) {
        if(i < 0 || i >= m || j < 0 || j >= n) {
            return 0;
        }
        if(matrix[i][j] != null) return matrix[i][j];
        int path = getUniquePaths(m,n, i-1, j, matrix) + getUniquePaths(m,n, i, j-1, matrix);
        matrix[i][j] = path;
        return path;
    }
}
