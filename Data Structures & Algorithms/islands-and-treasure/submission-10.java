class Solution {
    private int INF = 2147483647;
    int[][] directions = new int[][] {
        {-1,0}, {1,0}, {0,-1}, {0,1}
    };
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i<grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 0) {
                    q.add(new int[]{i,j});
                }
            }
        }

        while(!q.isEmpty()) {
            int[] t = q.poll();
            int i = t[0], j = t[1];
            int dis = grid[i][j];
            for(int[] dir: directions) {
                int nx = i + dir[0], ny = j + dir[1]; 
                if(nx < 0 || ny < 0 || nx >= grid.length || ny >= grid[0].length) continue;
                if(grid[nx][ny] != INF || grid[nx][ny] == -1) continue;
                grid[nx][ny] = dis + 1;
                q.add(new int[]{nx,ny});
            }
        }

        return;
    }
}
