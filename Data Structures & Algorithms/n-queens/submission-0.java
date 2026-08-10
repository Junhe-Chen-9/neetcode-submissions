class Solution {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] grid = new char[n][n];
        for(char[] row : grid) Arrays.fill(row,'.');
        backtrack(0,grid);
        return res;
    }
    private void backtrack(int r, char[][] board){
        // base case 
        if(r == board.length){
            List<String> copy = new ArrayList<>();
            for (char[] row : board) {
                copy.add(new String(row));
            }
            res.add(copy);
            return;
        }
        for(int c = 0; c < board.length; c ++){
            if(isSafe(r,c,board)){
                board[r][c] = 'Q';
                backtrack(r + 1, board);
                board[r][c] = '.'; // backtrack
            }
        }
    }
    private boolean isSafe(int r, int c, char[][] board) {
        for (int i = r - 1; i >= 0; i--) {
            if (board[i][c] == 'Q') return false;
        }
        for (int i = r - 1, j = c - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }
        for (int i = r - 1, j = c + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }
        return true;
    }
}
