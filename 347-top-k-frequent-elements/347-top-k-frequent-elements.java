class Solution {
    
    Map map = new HashMap<Integer,Integer>();
    Map result = new HashMap<Integer,ArrayList<Integer>>();
    
    public int[] topKFrequent(int[] nums, int k) {
        
        if(nums.length == 1){
            return nums;
        }
        
        for(int i : nums)
        {
            if(!map.containsKey(i))
            {
                map.put(i,1);
            }
            else 
            {
                map.put(i,((Integer)map.get(i))+1);
            }    
        }
        
    
        
        // 
        for(Object key: map.keySet()){
            
            
            int value = (Integer)map.get(key);
            
            
            if(result.containsKey(value)){
                ArrayList<Integer> list = (ArrayList<Integer>)result.get(value);
                list.add((Integer)key);
                
            } else{
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add((Integer)key);
                result.put(value,list);
            }
            
                
            
        }
        
        //System.out.println(result.get(2));
        
        int[] output = new int[k];
        int kCount = 0;
        // Constant size
        for(int i = nums.length; i > 0; i--)
        {

             if(result.containsKey(i)){
                 
                ArrayList<Integer> list = (ArrayList<Integer>)result.get(i);
                
                 // Constant time
                for(Integer integer: list){
                    
                    if(kCount >= k){
                        break;
                    }
                    output[kCount] = (Integer)integer;
                    kCount++;
                }
                
            }
            
            if(kCount >= k){
                break;
            }    
        }
        
        return output;
    }
}
// Read Question Properly
// Time Complexity: O(n)
// Space Complexity: O(n)