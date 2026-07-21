class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i : stones){
            queue.offer(i);
        }
        while (queue.size() > 1){
            int x = queue.poll();
            int y = queue.poll();
            if(x != y){
                int compute = x - y;
                queue.offer(compute);
            }
        }

        queue.offer(0);
        return Math.abs(queue.peek());
    }
}
