class KthLargest {
    
    int k;
    Queue<Integer> pq = new PriorityQueue<>();

    public KthLargest(int k, int[] nums) {
        
        this.k = k;
        
        for(int i: nums){
            pq.add(i);
        }
    }
    
    public int add(int val) {
        
        pq.add(val);
        
        while(pq.size() > k){        
            pq.poll();
        }
        
        return pq.peek();
    }
}
// Time Complexity: O(n log n)
// Space Complexity: O(n)

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */