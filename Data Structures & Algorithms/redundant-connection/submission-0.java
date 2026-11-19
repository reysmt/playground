class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i <= edges.length; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
            boolean[] visit = new boolean[edges.length+1];

            if(dfs(edge[0], -1, adj, visit)){
                return edge;
            }
        }

        return new int[0];
    }

    //adj : [[], [2, 3], [1, 4], [1, 4], [3, 2]]
    private boolean dfs(int node, int parent, List<List<Integer>> adj, boolean[] visit){
        if(visit[node]){
            return true;
        }

        visit[node] = true;
        for(int nei : adj.get(node)){
            if(nei == parent) {
                continue;
            }

            if(dfs(nei, node, adj, visit)){
                return true;
            }
        }
        return false;
    }
}
