class MedianFinder {

    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a, b) -> a - b);
        minHeap = new PriorityQueue<>((a, b) -> b - a);
    }
    
    public void addNum(int num) {
        minHeap.offer(num);
        if(maxHeap.size() - minHeap.size() > 1){
            minHeap.offer(maxHeap.poll());
        }else if (minHeap.size() - maxHeap.size() > 1 || !maxHeap.isEmpty() && minHeap.peek() > maxHeap.peek()){
            maxHeap.offer(minHeap.poll());
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
