class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int orig = image[sr][sc];

        if (orig == color)
            return image;

        int row = image.length;
        int col = image[0].length;

        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[] {sr, sc});
        image[sr][sc] = color;

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int r = cell[0];
            int c = cell[1];
            for (int[] dir : dirs) {
                if (r + dir[0] >= 0 && r + dir[0] < row && c + dir[1] >= 0 && c + dir[1] < col
                    && image[r + dir[0]][c + dir[1]] == orig) {
                    image[r + dir[0]][c + dir[1]] = color;
                    q.add(new int[] {r + dir[0], c + dir[1]});
                }
            }
        }

        return image;
    }
}