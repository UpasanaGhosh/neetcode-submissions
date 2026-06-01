class MedianFinder {
    PriorityQueue<Integer> minHeap; // for large elements
    PriorityQueue<Integer> maxHeap; // for small elements

    public MedianFinder() {
        this.minHeap = new PriorityQueue<>();
        this.maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        this.maxHeap.offer(num);

        if(this.maxHeap.size() - this.minHeap.size() > 1 
        || !this.minHeap.isEmpty() 
        && this.maxHeap.peek() > this.minHeap.peek()){
            this.minHeap.offer(this.maxHeap.poll());
        }

        if(this.minHeap.size() - this.maxHeap.size() > 1)
        {
           this.maxHeap.offer(this.minHeap.poll()); 
        }
    }
    
    public double findMedian() {
       if((maxHeap.size() == minHeap.size())){
            return (double)(maxHeap.peek() + minHeap.peek())/2;
       }
       else if(maxHeap.size() > minHeap.size()){
            return maxHeap.peek();
       } 
       else{
            return minHeap.peek();
       }
    }
}
/*
minHeap = 3
maxHeap = 1, 2
*/
