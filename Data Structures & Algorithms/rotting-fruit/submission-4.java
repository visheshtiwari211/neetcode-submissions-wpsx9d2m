class Solution {
    public int orangesRotting(int[][] grid) {
        int ROWS = grid.length, COLS=grid[0].length;
        int minute = -1;
        Deque<int[]> q = new ArrayDeque<>();
        boolean isFresh = false;
        for(int i = 0; i<ROWS;i++) {
            for(int j =0;j<COLS;j++) {
                if(grid[i][j] == 2) {
                    q.add(new int[]{i,j});
                    isFresh = true;
                }
                if(grid[i][j] != 0) isFresh = true;
            }
        }
        if(!isFresh) {
            return 0;
        }

        while(!q.isEmpty()) {
            int qSize = q.size();
            for(int i = 0; i<qSize; i++) {
                int[] pair = q.poll();
                int r = pair[0], c = pair[1];

                int[][] neighbours = {{r, c+1}, {r, c-1}, {r-1, c}, {r+1, c}};
                for(int j = 0; j<4; j++) {
                    int newR = neighbours[j][0], newC = neighbours[j][1];
                    if(newR<0 || newR >= ROWS || newC<0 || newC >= COLS || grid[newR][newC] != 1) {
                        continue;
                    }
                    grid[newR][newC] = 2;
                    q.add(new int[]{newR,newC});
                } 
            }
            minute++;
        }

        for(int i = 0; i<ROWS;i++) {
            for(int j =0;j<COLS;j++) {
                if(grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return minute;

    }
}
