class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int fArea = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i = 0; i<grid.length; i++) {
            for(int j = 0; j<grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    int a = getArea(grid, visited, i, j, 0);
                    fArea = Math.max(a, fArea);
                }
            }
        }
        return fArea;
    }

    public int getArea(int[][] grid, boolean[][] visited, int i, int j, int area) {
        if(i < 0 || i>=grid.length || j < 0 || j>=grid[0].length) return 0;
        if(grid[i][j] == 0 || visited[i][j]) return 0;
        visited[i][j] = true;
        int start = getArea(grid, visited, i+1, j, area);
        int end = getArea(grid, visited, i-1, j, area); 
        int top = getArea(grid, visited, i, j+1, area); 
        int bottom = getArea(grid, visited, i, j-1, area); 
        int sibAr = start + end + top + bottom;
        area += sibAr;
        area+=1;
        return area;
    }
}
