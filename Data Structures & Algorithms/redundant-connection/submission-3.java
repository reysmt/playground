class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        DSU dsu = new DSU(edges.length + 1);

        for(int[] edge : edges){
            if(!dsu.union(edge[0], edge[1])){
                return new int[]{edge[0], edge[1]};
            }
        }

        return new int[0];
    }
}

class DSU {
    int[] parent, size;

    public DSU(int n){
        parent = new int[n + 1];
        size = new int[n + 1];
        for(int i = 0; i < n; i++){
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int node){
        if(parent[node] != node){
            parent[node] = parent[parent[node]];
        }
        return parent[node];
    }

    public boolean union(int nodeOne, int nodeTwo){
        int u = find(nodeOne);
        int v = find(nodeTwo);

        if(u == v){
            return false;
        }

        if(size[u] > size[v]){
            parent[v] = u;
            size[u] += size[v];
        }else{
            parent[u] = v;
            size[v] += size[u];
        }

        return true;
    }
}
