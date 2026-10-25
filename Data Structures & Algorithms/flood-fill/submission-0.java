class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int orig = image[sr][sc];
        if(orig == color){
            return image;
        }

        int row = image.length;
        int col = image[0].length;

        dfs(image, sr, sc, color, orig);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int color, int orig){
        if(sr >= image.length || sr < 0 
            || sc >= image[0].length || sc < 0 || image[sr][sc] != orig){
                return;
            }
        image[sr][sc] = color;
        dfs(image, sr + 1, sc, color, orig);
        dfs(image, sr - 1, sc, color, orig);
        dfs(image, sr, sc + 1, color, orig);
        dfs(image, sr, sc - 1, color, orig);
    }
}