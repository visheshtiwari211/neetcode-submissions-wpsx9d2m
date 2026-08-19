class Solution {
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int minimumEffortPath(int[][] heights) {
        int maxDiff = 1000000;
        int min = 0;
        int minW = 0;

        while(min <= maxDiff) {
            int mid  = (min + maxDiff)/2;
            if(canReach(heights, mid, new boolean[heights.length][heights[0].length])) {
                minW = mid;
                maxDiff = mid-1;
            } else {
                min = mid + 1;
            }
        }
        return minW;
    }

    public boolean canReach(int[][] heights, int maxWeight, boolean[][] visited) {
        if (heights.length == 1 && heights[0].length == 1) return true;
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[] {0, 0});
        visited[0][0] = true;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size > 0) {
                int[] curr = q.poll();
                size--;
                int i = curr[0], j = curr[1];
                for (int[] dir : dirs) {
                    int x = i + dir[0], y = j + dir[1];

                    if (x >= 0 && y >= 0 && x < heights.length && y < heights[0].length
                        && !visited[x][y]) {
                        int diff = Math.abs(heights[i][j] - heights[x][y]);
                        if (diff > maxWeight)
                            continue;
                        if (x == heights.length - 1 && y == heights[0].length - 1)
                            return true;
                        q.add(new int[] {x, y});
                        visited[x][y] = true;
                    }
                }
            }
        }

        return false;
    }
}