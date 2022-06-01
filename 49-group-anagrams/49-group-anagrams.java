class Solution {
    
    Map map = new HashMap<String,ArrayList<String>>();
    
    public List<List<String>> groupAnagrams(String[] strs) {
    
        
        List<List<String>> output = new ArrayList<List<String>>();
        
        
        for(String s: strs){  // <------------ O(n)
            
            char[] charArray = s.toCharArray();

            Arrays.sort(charArray); // <------------ O(n log n)
            
            String key = new String(charArray);
            
            if(map.containsKey(key)){
                List list = (List<String>) map.get(key);
                list.add(s);
            } else{
                List innterList = new ArrayList<String>();
                innterList.add(s);
                map.put(key,innterList);
            }
        }
        
        
        for (Object list : map.values())
            output.add((List<String>) list);
        
            
        return output;
    }
}

// Time Complexity: O( n^2 log n) -> O(n^2)
// Space Complexity: O(n) <--- Not So Sure