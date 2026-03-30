class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int count = 0;
        int r= grid.length, c = grid[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 1) {
                    int tempCount = biggestIsland(grid, j, i, 0);    
                    if(tempCount > count) {
                        count = tempCount;
                    }
                }
            }
        }
        return count;
    }

    private int biggestIsland(int[][] grid, int j, int i, int count) {
        int r= grid.length, c = grid[0].length;

        if(i<0||i>=r) return 0;
        if(j<0||j>=c) return 0;

        if(grid[i][j] != 1) return 0;
        grid[i][j] = 0;

        count++;
        count+=biggestIsland(grid,j,i + 1,0);
        count+=biggestIsland(grid,j,i - 1,0);
        count+=biggestIsland(grid,j + 1,i,0);
        count+=biggestIsland(grid,j - 1,i,0);

        return count;
    }
}
