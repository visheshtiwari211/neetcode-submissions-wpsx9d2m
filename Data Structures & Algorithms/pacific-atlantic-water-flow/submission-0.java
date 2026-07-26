class Solution {
    int[][] direction = new int[][] {
            {1,0}, {-1, 0}, {0,-1}, {0,1}
        };
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length, cols = heights[0].length;
        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        for(int i = 0; i < rows; i++) {
            getReachable(heights, pacific, i, 0);
            getReachable(heights, atlantic, i, cols - 1);
        }
        for(int j = 0; j < cols; j++) {
            getReachable(heights, pacific, 0, j);
            getReachable(heights, atlantic, rows - 1, j);
        }

        List<List<Integer>> l = new ArrayList<>();
        for(int i = 0; i<heights.length; i++) {
            for(int j = 0; j<heights[0].length; j++) {
                if(pacific[i][j] && atlantic[i][j]) {
                    l.add(new ArrayList<>(List.of(i,j)));
                }
            }
        }
        return l;
    }

    public void getReachable(int[][] heights, boolean[][] visited, int i, int j) {
        if(visited[i][j]) return;
        visited[i][j] = true;

        for(int[] dir: direction) {
            int nx = i + dir[0], ny = j + dir[1];
            if(nx < 0 || ny < 0 || nx>=heights.length || ny>=heights[0].length) continue;
            if(heights[nx][ny] >= heights[i][j]) getReachable(heights, visited, nx, ny);
        }
        return;
    }
}
