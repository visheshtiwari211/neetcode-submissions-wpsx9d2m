class Solution {
    public boolean exist(char[][] board, String word) { 
        for(int i =0; i<board.length; i++) {
            for(int j = 0; j<board[0].length; j++) {
                boolean ans = e(board, word, i, j, 0);
                if(ans) return true;
            }
        }
        return false;
    }

    public boolean e(char[][] board, String word, int i, int j, int q) {
        if(q == word.length()) {
            return true;
        }
        if(i < 0 || i>=board.length || j < 0 || j >= board[0].length) {
            return false;
        }
        if(board[i][j] == '*') {
            return false;
        } 

        char replaced = 'A';
        boolean found = false;
        if(board[i][j] == word.charAt(q)) {
            replaced = board[i][j];
            board[i][j] = '*';
            found = true;
            q++;
        }
        
        if(found) {
            boolean left = e(board, word, i - 1, j, q);
            boolean right = e(board, word, i + 1, j, q);
            boolean top = e(board, word, i, j - 1, q);
            boolean bottom = e(board, word, i, j + 1, q);

            board[i][j] = replaced;
            return left || right || top || bottom;
        }

        return false;
    }
}
