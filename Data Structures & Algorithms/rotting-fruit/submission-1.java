class Solution {
    public int orangesRotting(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        int fresh = 0;
        int minutes = 0;
        Queue<int[]> queue = new LinkedList<>();

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == 2) {
                    queue.add(new int[] {r, c});
                } else if (grid[r][c] == 1) {
                    fresh++;
                }
            }
        }
        
        int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        while (!queue.isEmpty() && fresh > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] node = queue.poll();
                int row = node[0];
                int col = node[1];
                for (int[] dir : dirs) {
                    int r = row + dir[0];
                    int c = col + dir[1];
                    if (r < 0 || c < 0 || r >= ROWS || c >= COLS || grid[r][c] != 1) {
                        continue;
                    }

                    queue.add(new int[] {r, c});
                    grid[r][c] = 2;
                    fresh--;
                }
            }
            minutes++;
        }
        return fresh == 0 ? minutes : -1;
    }
}
