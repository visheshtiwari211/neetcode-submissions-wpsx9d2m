class Solution {
    public int islandPerimeter(int[][] grid) {
        int count = 0;
        for(int i = 0; i< grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                int c = 0;
                if(grid[i][j]==1) {
                    if(i-1 < 0 || grid[i-1][j] == 0 ) {
                    c++;
                }

                if(i+1 >= grid.length || grid[i+1][j] == 0 ) {
                    c++;
                }

                if(j-1 < 0 || grid[i][j-1] == 0 ) {
                    c++;
                }

                if(j+1 >= grid[0].length || (j+1 < grid[0].length && grid[i][j+1] == 0 )) {
                    c++;
                }
                }
                count += c;
            }
        }
        return count;
    }
}