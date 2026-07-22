class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        for(int[] point : points){
            int distance = point[0] * point[0] + point[1] * point[1];
            minHeap.offer(new int[]{distance, point[0], point[1]});
        }

        int[][] res = new int[k][2];
        int index = 0;

        for (int i = 0; i < k; ++i) {
            int[] point = minHeap.poll();
            res[index++] = new int[]{point[1], point[2]};
        }

        return res;
    }
}
