class Solution {
    int[][] direction = new int[][] {
            {1,0}, {-1, 0}, {0,-1}, {0,1}
        };
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length, cols = heights[0].length;
        Queue<int[]> pacific = new LinkedList<>();
        Queue<int[]> atlantic = new LinkedList<>();

        boolean[][] pVisited = new boolean[rows][cols];
        boolean[][] aVisited = new boolean[rows][cols];

        int i = 0;
        for(int j = 0; j < cols; j++) {
            pVisited[0][j] = true;
            pacific.add(new int[]{0, j});
            aVisited[rows-1][j] = true;
            atlantic.add(new int[]{rows-1, j});
        }
        for(i = 0; i < rows; i++) {
            pVisited[i][0] = true;
            pacific.add(new int[]{i, 0});
            aVisited[i][cols-1] = true;
            atlantic.add(new int[]{i, cols-1});
        }

        bfs(heights, pacific, pVisited);
        bfs(heights, atlantic, aVisited);


        List<List<Integer>> l = new ArrayList<>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (pVisited[r][c] && aVisited[r][c]) {
                    l.add(Arrays.asList(r, c));
                }
            }
        }
        return l;

}
    private void bfs(int[][] heights, Queue<int[]> q, boolean[][] visited) {
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            for(int[] dir : direction) {
                int nx = curr[0] + dir[0], ny = curr[1] + dir[1];
                if(nx >= 0 && nx < heights.length && ny >= 0 && ny < heights[0].length && 
                   !visited[nx][ny] && heights[nx][ny] >= heights[curr[0]][curr[1]]) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }
}
