class Solution {
    private int[][] memo;
    public int uniquePaths(int m, int n) {
        memo = new int[m][n];

        for(int[] it : memo){
            Arrays.fill(it, -1);
        }

        return dfs(m, n, 0, 0);
    }

    private int dfs(int m, int n, int i, int j){
        
        if(i == m || j == n){
            return 0;
        }

        if(memo[i][j] != -1){
            return memo[i][j];
        }

        if(i == m - 1 || j == n - 1){
            return 1;
        }

        return memo [i][j] = dfs(m, n, i, j + 1) + dfs(m, n, i + 1, j);
    }
}
