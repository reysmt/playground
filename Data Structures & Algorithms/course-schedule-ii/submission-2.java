class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[numCourses];
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] pre : prerequisites){
            adj.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }

        Deque<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < numCourses; i ++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }

        while(!queue.isEmpty()){
            int u = queue.poll();
            res.add(u);

            for(int v : adj.get(u)){
                indegree[v] --;
                if(indegree[v] == 0){
                    queue.add(v);
                }
            }
        }

        return res.size() != numCourses ? new int[0]: res.stream().mapToInt(i -> i).toArray();
    }
}
