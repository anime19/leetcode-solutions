class Solution {
    public void solveSudoku(char[][] board) {
        rec(board);
    }
    public boolean rec(char[][] board) {
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(board[i][j]=='.') {
                    for(char c='1'; c<='9'; c++) {
                        if(isValid(board,i,j,c)) {
                            board[i][j] = c;
                            if(rec(board)) {
                                return true; //we have to find just one solution sincne there can beonly one solution possible
                            }
                            board[i][j]='.';
                        }
                    }
                    return false; // current cell cannot be filled because of some wrongly filled previous cell
                }
            }
        }
        return true; //sudoku is already solved 
    }
    public static boolean isValid(char[][] board, int row, int col, char c) {
    for (int i = 0; i < 9; i++) {
      if (board[i][col] == c)
        return false;

      if (board[row][i] == c)
        return false;

      if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c)
        return false;
    }
    return true;
  }
}

// void solveSudokuAll(char[][] board, List<char[][]> allSolutions) {
//     backtrack(board, allSolutions);
// }

// void backtrack(char[][] board, List<char[][]> allSolutions) {
//     for (int row = 0; row < 9; row++) {
//         for (int col = 0; col < 9; col++) {
//             if (board[row][col] == '.') {
//                 for (char c = '1'; c <= '9'; c++) {
//                     if (isValid(board, row, col, c)) {
//                         board[row][col] = c;
//                         backtrack(board, allSolutions);
//                         board[row][col] = '.';  // backtrack
//                     }
//                 }
//                 return; // important: if any empty cell remains, must fill before proceeding
//             }
//         }
//     }

//     // Base case: all cells are filled and valid
//     char[][] copy = deepCopy(board);
//     allSolutions.add(copy);
// }
