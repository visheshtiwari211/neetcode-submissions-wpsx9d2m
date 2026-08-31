class Solution {
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int swimInWater(int[][] grid) {
        int start = 0, end = Integer.MAX_VALUE;
        int minValue = -1;
        while(start <= end) {
            int mid = start + (end - start)/2;
            if(findPath(mid, grid, new boolean[grid.length][grid[0].length])) {
                minValue = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return minValue;
    }

    public boolean findPath(int maxValue, int[][] grid, boolean[][] visited) {
        if (grid[0][0] > maxValue) return false;
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{0, 0});
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] e = q.poll();
            int i = e[0], j = e[1];
            if (i == grid.length - 1 && j == grid.length - 1) return true;
            for (int[] dir: dirs) {
                int x = i + dir[0], y = j + dir[1];
                if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || visited[x][y]) continue;
                if(grid[x][y] > maxValue) continue;
                visited[x][y] = true;
                q.offer(new int[]{x,y});
            }
        }

        return false;
    }
}
