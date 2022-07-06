class Solution {
    
   class Pair {
        int start,end;
        
        Pair(int start,int  end){
            this.start = start;
            this.end = end;
        }
        public int[] toArray() {
            return new int[]{start,end};
        }
    }
    
    public int[][] merge(int[][] intervals) {
     
        // Sort by Start Time
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        
        System.out.println(Arrays.deepToString(intervals)); // O(n log n)
        
        LinkedList<Pair> list = new LinkedList<>();
        
        // Add 1st element
        
        list.add(new Pair(intervals[0][0],intervals[0][1]));
        
        for(int i = 1; i< intervals.length; i++){
            Pair p = list.getLast();
            if(p.end>= intervals[i][0]){
                p.end = Math.max(intervals[i][1],p.end);
            } else{
                list.add(new Pair(intervals[i][0],intervals[i][1]));
            }
        }
        
        int[][] merged = new int[list.size()][];
        int k=0;
        for(Pair p: list){
            merged[k] = p.toArray();
            k++;
        }
        return merged;
    }
}