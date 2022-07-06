class Solution {


    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        ArrayList<int[]> list = new ArrayList<>();
        
        boolean flag = true;
        
        int k = 0; 
        for(int[] interval : intervals){
            
            if(newInterval[1] < interval[0]){
                list.add(newInterval);
                flag = false;
                break;
            } else if(interval[1] < newInterval[0]){
                list.add(interval);
            } else {
                newInterval[0] = Math.min(interval[0],newInterval[0]);
                newInterval[1] = Math.max(interval[1],newInterval[1]);
            }
            
            k++;
            
        }

        
        if(flag){
            list.add(newInterval);
        } else {
            for(int l = k ; l < intervals.length; l++){
                 list.add(intervals[l]);
            }
        }
        
        int[][] result = new int[list.size()][];
        
        for(int i =0; i < result.length; i++){
            result[i] = (int[]) list.get(i);
        }
        
        return result;
    }
}