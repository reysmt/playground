class Solution {
    List<List<Integer>> adjList = new ArrayList<>();
    Set<Integer> seen = new HashSet<>();
    public boolean validTree(int n, int[][] edges) {
        for(int i = 0; i < n; i++){
            adjList.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        System.out.println(adjList);
        
        if(!dfs(0, -1)){
            return false;
        }
        return seen.size() == n;
    }

    private boolean dfs(int n, int parent){
        if(seen.contains(n)){
            return false;
        }
        seen.add(n);
        for(int nei : adjList.get(n)){
            if(nei == parent){
                continue;
            }
            if(!dfs(nei, n)){
                return false;
            }
        }
        return true;
    }
}
