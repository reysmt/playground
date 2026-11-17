class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] pre : prerequisites){
            int u = pre[0];
            int v = pre[1];
            adj.get(u).add(v);
            indegree[v]++;
        }

        Deque<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }

        int finishCount = 0;
        while(!queue.isEmpty()){
            int u = queue.poll();
            finishCount ++;
            for(int v : adj.get(u)){
                indegree[v] --;
                if(indegree[v] == 0){
                    queue.add(v);
                }
            }
        }

        return finishCount == numCourses;

    }
}
