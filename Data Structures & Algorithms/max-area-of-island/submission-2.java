class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;

        DSU dsu = new DSU(ROWS * COLS);

        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        int area = 0;
        for(int r = 0; r < ROWS; r++){
            for(int c = 0; c < COLS; c++){
                if(grid[r][c] == 1){
                    for(int[] dir : directions){
                        int nr = r + dir[0];
                        int nc = c + dir[1];
                        if(nr >= 0 && nc >= 0 && nr < ROWS && nc < COLS && grid[nr][nc] == 1){
                            dsu.union(r * COLS + c, nr * COLS + nc);
                        }
                    }
                    area = Math.max(area, dsu.getSize(r + COLS + c));
                }
            }
        }
        return area;
    }
}

class DSU{
    private int[] parent, size;

    public DSU(int n){
        parent = new int[n + 1];
        size = new int[n + 1];
        for(int i = 0; i <= n; i++){
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int node){
        if(node != parent[node]){
            parent[node] = find(parent[node]);
        }
        return parent[node];
    }

    public boolean union(int u, int v){
        int pu = find(u);
        int pv = find(v);
        if(pu == pv) return false;
        if(size[pu] >= size[pv]){
            size[pu] += size[pv];
            parent[pv] = pu;
        }else {
            size[pv] += size[pu];
            parent[pu] = pv;
        }

        return true;
    }

    public int getSize(int node){
        return size[find(node)];
    }
}
