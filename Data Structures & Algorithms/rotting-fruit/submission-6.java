class Solution {
    int[][] distances = new int[][] {
        {1,0}, {-1,0}, {0,-1}, {0,1}
    };
    public int orangesRotting(int[][] grid) {
        int maxDist = 0;
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i<grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 2) {
                    q.add(new int[]{i,j,0});
                }
            }
        }

        while(!q.isEmpty()) {
            int[] coord = q.poll();
            int i = coord[0], j = coord[1], d = coord[2];
            for(int[] dist: distances) {
                int nx = i + dist[0], ny = j + dist[1];
                if(nx < 0 || ny < 0 || nx >= grid.length || ny >= grid[0].length) continue;
                if(grid[nx][ny] != 1) continue;
                grid[nx][ny] = 2;
                maxDist = Math.max(d + 1, maxDist);
                q.add(new int[]{nx,ny,d + 1});
            }
        }

        for(int i = 0; i<grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return maxDist;
    }
}
