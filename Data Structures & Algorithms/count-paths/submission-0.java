class Solution {
    public int uniquePaths(int m, int n) {
        int[][] grid = new int[m][n];
        return dfs(m, n, 0, 0);
    }

    private int dfs(int m, int n, int i, int j){
        
        if(i == m || j == n){
            return 0;
        }

        if(i == m - 1 || j == n - 1){
            return 1;
        }

        return dfs(m, n, i, j + 1) + dfs(m, n, i + 1, j);
    }
}
