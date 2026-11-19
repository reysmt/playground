class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        Deque<Integer> queue = new ArrayDeque<>();
        int n = edges.length;
        int[] indegree = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
            indegree[edge[0]]++;
            indegree[edge[1]]++;
        }

        for(int i = 1; i<=n; i++){
            if(indegree[i] == 1) queue.offer(i);
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();
            indegree[node] --;
            for (int nei : adj.get(node)) {
                indegree[nei]--;
                if (indegree[nei] == 1) {
                    queue.add(nei);
                }
            }
        }

        for(int i = edges.length - 1; i >= 0; i--){
            int u = edges[i][0], v = edges[i][1];
            if(indegree[u] == 2 && indegree[v] > 0){
                return new int[]{u, v};
            }
        }
        return new int[0];
    }
}
