class Solution {
    int ROWS, COLS;
    Set<Pair<Integer, Integer>> set = new HashSet<>();
    public boolean exist(char[][] board, String word) {
        ROWS = board.length; COLS = board[0].length;

        for(int r = 0; r<ROWS; r++) {
            for(int c = 0; c<COLS; c++) {
                if(dfs(r, c, board, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(int r, int c, char[][] board, String word, int i) {
        if(i >= word.length()) {
            return true;
        }

        if(r<0 || c<0 || r>= ROWS || c>=COLS || board[r][c] != word.charAt(i)||set.contains(new Pair(r,c))) {
            return false;
        }

        set.add(new Pair(r,c));
        boolean res = (
            dfs(r-1, c, board, word, i+1)
            ||
            dfs(r+1, c, board, word, i+1)
            ||
            dfs(r, c-1, board, word, i+1)
            ||
            dfs(r, c + 1, board, word, i+1)
        );
        set.remove(new Pair(r,c));
        return res;
    }
}
