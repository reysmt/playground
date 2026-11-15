class Solution {
    public void solve(char[][] board) {
        int ROWS = board.length;
        int COLS = board[0].length;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        DSU dsu = new DSU(ROWS * COLS);

        for(int r = 0; r < ROWS; r ++){
            for(int c = 0; c < COLS; c++){
                if(board[r][c] != 'O') continue;
                if(r == 0 || c == 0 || r == ROWS - 1 || c == COLS - 1){
                    dsu.union(ROWS * COLS, r * COLS + c);
                }else{
                    for(int[] dir : directions){
                        int nr = r + dir[0];
                        int nc = c + dir[1];
                        if(board[nr][nc] == 'O'){
                            dsu.union(r * COLS + c, nr * COLS + nc);
                        }
                    }
                }
            }
        }
        
        for(int r = 0; r < ROWS; r++){
            for(int c = 0; c < COLS; c++){
                if(!dsu.connected(ROWS * COLS, r * COLS + c)){
                    board[r][c] = 'X';
                }
            }
        }
    }
}

class DSU{
    int[] parent,size;

    public DSU(int n){
        parent = new int[n + 1];
        size = new int[n + 1];
        for(int i = 0; i <= n; i++){
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int node){
        if(parent[node] != node){
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
        }else{
            size[pv] += size[pu];
            parent[pu] = pv;
        }
        return true;
    }

    public boolean connected(int u, int v){
        return find(u) == find(v);
    }
}
