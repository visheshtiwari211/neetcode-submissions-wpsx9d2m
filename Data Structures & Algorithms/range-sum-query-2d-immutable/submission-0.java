class NumMatrix {
    int[][] sum;

    public NumMatrix(int[][] matrix) {
        sum = new int[matrix.length][matrix[0].length + 1];
        
        for(int i = 0; i < matrix.length; i++) {
            int sum1 = 0;

            sum[i][0] = 0;

            for(int j = 0; j < matrix[0].length; j++) {
                
                sum1 += matrix[i][j];
                sum[i][j+1] = sum1;
            }
        }
        
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        
        int top_row = row1;
        int bottom_row = row2;
        int sum1 = 0;
        while (top_row <= bottom_row ) {
            sum1 += sum[top_row][col2 + 1] - sum[top_row][col1];
            top_row++;
        }

        return sum1;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */