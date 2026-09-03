class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;

        // PriorityQueue stores: [time, row, col]
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        boolean[][] visited = new boolean[n][n];

        // 4 possible directions: down, up, right, left
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        // Start at (0, 0)
        pq.offer(new int[]{grid[0][0], 0, 0});
        visited[0][0] = true;

        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int time = top[0], r = top[1], c = top[2];

            // Reached destination bottom-right cell
            if (r == n - 1 && c == n - 1) {
                return time;
            }

            // Explore 4 neighbors on the fly
            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                // Boundary check & visited check
                if (nr >= 0 && nr < n && nc >= 0 && nc < n && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    // The time needed to enter (nr, nc) is max of current time and grid[nr][nc]
                    pq.offer(new int[] {Math.max(time, grid[nr][nc]), nr, nc});
                }
            }
        }

        return -1;
    }
}
