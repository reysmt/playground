class Solution {
    public int islandPerimeter(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int res = 0;
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(grid[i][j] == 1){
                    res += (i + 1 >= r || grid[i+1][j] == 0) ? 1 : 0;
                    res += (j + 1 >= c || grid[i][j + 1] == 0) ? 1 : 0;
                    res += (i - 1 < 0 || grid[i-1][j] == 0) ? 1 : 0;
                    res += (j - 1 < 0 || grid[i][j-1] == 0) ? 1 : 0; 
                }
            }
        }
        return res;
    }
}