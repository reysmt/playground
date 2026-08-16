class Solution {
    List<List<Integer>> adjList = new ArrayList<>();
    Set<Integer> seen = new HashSet<>();
    int res = 0;
    public int countComponents(int n, int[][] edges) {
        for(int i = 0; i < n; i++){
            adjList.add(i, new ArrayList<>());
        }

        for(int[] edge : edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        for(int node = 0; node < n; node++){
            if(!seen.contains(node)){
                dfs(node, -1);
                res++;
            }
        }
        return res;
    }

    private void dfs(int node, int parent){
        if(seen.contains(node)){
            return;
        }
        seen.add(node);
        for(int nei : adjList.get(node)){
            if(nei == parent){
                continue;
            }
            dfs(nei, node);
        }
    }
}
