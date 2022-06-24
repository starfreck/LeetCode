class Solution {
    
    Queue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
    
    public int lastStoneWeight(int[] stones) {
        
        for(int stone : stones){
            pq.add(stone);
        }
        
        while(pq.size() > 1){
            
            int y = pq.poll();
            int x = pq.poll();
   
            if(x != y){
                pq.add(y-x);
            }
        }
        
        if(pq.isEmpty()){
            return 0;
        }
        return pq.poll();
    }
}
// Time Complexity: O(n log n)
// Space Complexity: O(n)