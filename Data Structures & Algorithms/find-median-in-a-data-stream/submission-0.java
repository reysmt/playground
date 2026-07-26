class MedianFinder {

    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        minHeap.offer(num);
        if(maxHeap.size() - minHeap.size() > 1){
            int tempMax = maxHeap.poll();
            minHeap.offer(tempMax);
        }else{
            maxHeap.offer(num);
        }
    }
    
    public double findMedian() {
        if(maxHeap.size() == minHeap.size()){
            return (double)(maxHeap.peek() + minHeap.peek()) / 2;
        }else if(minHeap.size() > maxHeap.size()){
            return (double)minHeap.peek();
        }else {
            return (double)maxHeap.peek();
        }
    }
}
