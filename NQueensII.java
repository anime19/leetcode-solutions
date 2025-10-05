class Solution {
    int columnsPlaced[];
    public int totalNQueens(int n) {
        columnsPlaced = new int[n];
        return rec(0, n);
    }
    public int rec(int row, int targetRow) {
        if(row==targetRow) return 1; //we have succefully placed columns till n-1 rows so this is a valid ans

        //for each row we have n columns as in n choices where we can place queen dependin upon the validity of the cell
        int ans=0;
        for(int col=0; col<targetRow; col++) {
            if(isValidCell(row, col)) {
                columnsPlaced[row] = col;
                ans +=rec(row+1, targetRow);
                columnsPlaced[row] = 0;
            }
        }
        return ans;
    }
    public boolean isValidCell(int currRow, int currCol) {
        for(int i=0; i<currRow; i++) {
            int prevRow = i;
            int prevCol = columnsPlaced[prevRow];
            if(currCol==prevCol || Math.abs(currRow-prevRow) == Math.abs(currCol - prevCol)) return false;
        }
        return true;
    }
}
