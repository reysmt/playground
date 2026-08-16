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
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, -1});
        seen.add(0);

        while(!q.isEmpty()){
            int[] pair = q.poll();
            int node = pair[0], parent = pair[1];
            for (int nei : adjList.get(node)){
                if(nei == parent){
                    continue;
                }
                if(seen.contains(nei)){
                    return false;
                }
                seen.add(nei);
                q.offer(new int[]{nei, node});
            }
        }
        return seen.size() == n;
    }
}
