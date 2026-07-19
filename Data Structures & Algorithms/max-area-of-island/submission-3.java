class Solution {
    int[][] directions = new int[][] {
        {1, 0},
        {-1, 0},
        {0, 1},
        {0, -1}
    };
    public int maxAreaOfIsland(int[][] grid) {
        int fArea = 0;
        Queue<int[]> qArr = new LinkedList<>();
        for(int i = 0; i<grid.length; i++) {
            for(int j = 0; j<grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    int a = getArea(grid, qArr, i, j, 0);
                    fArea = Math.max(a, fArea);
                }
            }
        }
        return fArea;
    }

    public int getArea(int[][] grid, Queue<int[]> qArr, int i, int j, int area) {
        if(i < 0 || i>=grid.length || j < 0 || j>=grid[0].length) return 0;
        if(grid[i][j] == 0) return 0;
        qArr.add(new int[]{i, j});
        grid[i][j] = 0;

        while(!qArr.isEmpty()) {
            area++;
            int[] coord = qArr.poll();
            int x = coord[0], y = coord[1];
            for(int[] dir: directions) {
                int nx =  x + dir[0];
                int ny = y + dir[1];

                if(nx >= 0 && ny >= 0 && nx < grid.length && ny < grid[0].length && grid[nx][ny] == 1) {
                    qArr.add(new int[]{nx, ny});
                    grid[nx][ny] = 0;
                }
            }
        }

        return area;
    }
}
