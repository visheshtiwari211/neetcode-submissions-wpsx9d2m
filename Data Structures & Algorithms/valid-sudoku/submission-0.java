class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> seen = new HashSet();
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                if(board[i][j] != '.') {
                    String row = board[i][j] + "present in row " + i;
                    String col = board[i][j] + "present in col " + j;
                    String box = board[i][j] + "present in box " + i/3 + "-"+ j/3;

                    if(!seen.add(row) || !seen.add(col) || !seen.add(box)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
