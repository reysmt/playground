class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[1]));
        for(int[] point : points){
            if(minHeap.size() < k) minHeap.offer(point);
        }

        int[][] res = new int[minHeap.size()][];
        int index = 0;

        while(!minHeap.isEmpty()){
            res[index++] = minHeap.poll();
        }

        return res;
    }
}
