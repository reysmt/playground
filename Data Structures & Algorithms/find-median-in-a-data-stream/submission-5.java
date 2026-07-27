class MedianFinder {

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeapp;
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeapp = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        maxHeapp.offer(num);
        if(maxHeapp.size() - minHeap.size() > 1 || !minHeap.isEmpty() && maxHeapp.peek() > minHeap.peek()){
            minHeap.offer(maxHeapp.poll());
        }
        if (minHeap.size() - maxHeapp.size() > 1){
            maxHeapp.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        if(minHeap.size() == maxHeapp.size()){
            return (double)(minHeap.peek() + maxHeapp.peek()) / 2;
        }else if(maxHeapp.size() > minHeap.size()){
            return (double)maxHeapp.peek();
        }else {
            return (double)minHeap.peek();
        }
    }
}
