class Solution {
    int c = 0;
    public int islandPerimeter(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i = 0; i<grid.length; i++) {
            for(int j = 0; j<grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    getCount(grid, visited, i, j);
                    break;
                }
            }
        }
        return c;
    }

    public boolean getCount(int[][] grid, boolean[][] visited, int i, int j) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return true;
        if(visited[i][j]) return false;
        if(grid[i][j] == 0) return true;
        int count = 4;
        visited[i][j] = true;
        boolean left = getCount(grid, visited, i -1, j);
        if(!left) count--;
        boolean right = getCount(grid, visited, i + 1, j);
        if(!right) count--;
        boolean up = getCount(grid, visited, i, j - 1);
        if(!up) count--;
        boolean down = getCount(grid, visited, i, j + 1);
        if(!down) count--;
        c+=count;
        return false;
    }
}