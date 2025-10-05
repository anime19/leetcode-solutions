class Solution {
    int visited[];
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        visited = new int[n];
        Arrays.fill(visited, -1);
        rec(0,n, ans, new LinkedList<>());
        return ans;
    }
    public void rec(int rowIndex, int n, List<List<String>> ans, List<String> currAns) {
        if(rowIndex==n) {
            ans.add(new ArrayList<>(currAns));
            return;
        }
        if(rowIndex>n) {
            return;
        }
        for(int col=0; col<=n-1; col++) {
            char ch[] = new char[n];
            Arrays.fill(ch,'.');
            if(isValidPlacement(rowIndex, col)) {
                visited[rowIndex] = col;
                ch[col] = 'Q';
                currAns.add(String.valueOf(ch));
                rec(rowIndex+1, n, ans, currAns);
                currAns.removeLast();
                visited[rowIndex] = -1;
                ch[col] = '.';
            }
        }

    }

    public boolean isValidPlacement(int row, int col) {
        for(int i=0; i<row; i++) {
            int prevRow =i;
            int prevCol = visited[prevRow];
            if(col==prevCol || Math.abs(prevRow-row)== Math.abs(col-prevCol)) {
                return false;
            }
        }
        return true;
    }
}
