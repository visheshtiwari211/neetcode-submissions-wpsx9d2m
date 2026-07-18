class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i = 0; i<grid.length; i++) {
            for(int j = 0; j<grid[0].length; j++) {
                if(visited[i][j] == false && grid[i][j] == '1') {
                    count++;
                    getNoOfIslands(grid, visited, i, j);
                }
            }
        }
        return count;
    }

    public void getNoOfIslands(char[][] grid, boolean[][] visited, int i, int j) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return;
        if(visited[i][j] || grid[i][j] == '0') return;
        visited[i][j] = true;
        getNoOfIslands(grid, visited, i - 1, j);
        getNoOfIslands(grid, visited, i + 1, j);
        getNoOfIslands(grid, visited, i, j-1);
        getNoOfIslands(grid, visited, i, j+1);
        return;
    }
}
