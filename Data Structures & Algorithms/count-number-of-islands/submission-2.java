class Solution {
    int[][] directions = new int[][] {
        {1, 0},
        {-1, 0},
        {0,1},
        {0,-1}
    };
    public int numIslands(char[][] grid) {
        int count = 0;
        Queue<int[]> qArr = new LinkedList<>();
        for(int i = 0; i<grid.length; i++) {
            for(int j = 0; j<grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    count++;
                    getNoOfIslands(grid, qArr, i, j);
                }
            }
        }
        return count;
    }

    public void getNoOfIslands(char[][] grid, Queue<int[]> qArr, int i, int j) {
        if(grid[i][j] == '0') return;
        grid[i][j] = '0';
        qArr.add(new int[]{i, j});
        while(!qArr.isEmpty()) {
            int[] f = qArr.poll();
            int x = f[0], y = f[1]; 
            for(int[] dir: directions) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                if(nx >= 0 && ny >= 0 && nx < grid.length && ny < grid[0].length) {
                    getNoOfIslands(grid, qArr, nx, ny);
                }
            }
        }
        return;
    }
}
