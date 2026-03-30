class Solution {
    int count = 0;
    public int numIslands(char[][] grid) {
       int r = grid.length, c = grid[0].length;
       for(int i= 0; i<r; i++) {
        for(int j= 0; j<c; j++) {
            if(grid[i][j] != '0') {
                count++;
                countAllIslands(grid, i, j);
            }
        }
       }
       return count;
    }

    private void countAllIslands(char[][] grid, int i, int j) {
        int r = grid.length, c = grid[0].length;
        if(i >= r || i <0) return;
        if(j>=c || j<0) return;
        if(grid[i][j]=='0') return;

        grid[i][j] = '0';

        countAllIslands(grid, i+1, j);
        countAllIslands(grid, i-1, j);
        countAllIslands(grid, i, j+1);
        countAllIslands(grid, i, j-1);

        // visited.remove(pair);
    }
}
