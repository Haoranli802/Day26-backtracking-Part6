class Solution {
    List<List<String>> result;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        char[][] board = new char[n][n];
        for(char[] c : board) Arrays.fill(c, '.');
        backTracking(board, 0, n);
        return result;
    }
    private void backTracking(char[][] board, int num, int n){
        if(num == n){
            List<String> path = new ArrayList<>();
            for(char[] c : board){
                path.add(String.valueOf(c));
            }
            result.add(path);
            return;
        }
        for(int i = 0; i < n; i++){
            if(isValid(board, num, i)){
                board[num][i] = 'Q';
                backTracking(board, num + 1, n);
                board[num][i] = '.';
            }
        }
    }
    private boolean isValid(char[][] board, int r, int c){
        for(int i = r; i >= 0; i--){
            if(board[i][c] == 'Q') return false;
        }
        for(int i = c; i >= 0; i--){
            if(board[r][i] == 'Q') return false;
        }
        for(int i = r, j = c; i >= 0 && j >= 0; i--, j--){
            if(board[i][j] == 'Q') return false;
        }
        for(int i = r, j = c; i >= 0 && j < board.length; i--, j++){
            if(board[i][j] == 'Q') return false;
        }
        return true;
    }
}

//时间复杂度: O(n!)
//空间复杂度: O(n)
