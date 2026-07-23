class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        int[] count = new int[26];

        for(char task : tasks){
            count[task - 'A']++;
        }

        for(int cnt : count){
            if(cnt > 0){
                heap.add(cnt);
            }
        }

        int time = 0;
        Queue<int[]> q = new LinkedList<>();

        while(!heap.isEmpty() || !q.isEmpty()){
            time++;

            if(heap.isEmpty()){
                time = q.peek()[1];
            }else {
                int cnt = heap.poll() - 1;
                if(cnt > 0){
                    q.add(new int[]{cnt, time + n});
                }
            }

            if(!q.isEmpty() && q.peek()[1] == time){
                heap.add(q.poll()[0]);
            }
        }
        

        return time;
    }
}
