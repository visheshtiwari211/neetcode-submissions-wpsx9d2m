class Solution {
    int[][] direction = new int[][] {
        {0,1}, {0,-1},{-1,0},{1,0}
    };
    public void solve(char[][] board) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        Queue<int[]> q = new LinkedList<>();
        int rows = board.length, cols = board[0].length;
        for(int i = 0; i <rows; i++) {
            if(board[i][0] == 'O') q.add(new int[]{i,0});
            if(board[i][cols - 1] == 'O') q.add(new int[]{i,cols-1});
        }

        for(int j = 0; j <cols; j++) {
            if(board[0][j] == 'O') q.add(new int[]{0,j});
            if(board[rows-1][j] == 'O') q.add(new int[]{rows-1,j});
        }

        getBfs(board, visited, q);

        for(int i = 0; i<rows;i++) {
            for(int j = 0; j<cols;j++) {
                if(board[i][j] == 'O' && !visited[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
        return;
    }

    public void getBfs(char[][] board, boolean[][] visited, Queue<int[]> q) {
        while(!q.isEmpty()) {
            int[] head = q.poll();
            int i = head[0], j = head[1];
            visited[i][j] = true;
            for(int[] dir: direction) {
                int nx = i + dir[0], ny = j + dir[1];
                if(nx < 0 || ny < 0 || nx >= board.length || ny >= board[0].length) continue;
                if(board[nx][ny] == 'O' && !visited[nx][ny]) {
                    q.add(new int[]{nx,ny});
                }
            }
        }
    }
}
