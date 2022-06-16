class Solution {
    
    HashMap<Character,Integer> store1 = new HashMap<>();
    HashMap<Character,Integer> store2 = new HashMap<>();
    
    public boolean checkInclusion(String s1, String s2) {
        
        for(char c : s1.toCharArray()) {
            if (store1.containsKey(c))
                store1.put(c, store1.get(c) + 1);
            else
                store1.put(c, 1);
        }


        // 1. Create All Combination of s2 where length is s1.
        int r = 0, l = 0;
        int window = s1.length();

        for(int i = 0; i < s2.length(); i++){

            int currentWindowSize = (r-l+1);

            while(currentWindowSize <= window && r < s2.length()){
                if(store2.containsKey(s2.charAt(r)))
                    store2.put(s2.charAt(r),store2.get(s2.charAt(r))+1);
                else
                    store2.put(s2.charAt(r),1);
                r++;
                currentWindowSize = (r-l+1);
            }

            if(compare()){
                return true;
            }

            if(store2.containsKey(s2.charAt(l))){

                if((int) store2.get(s2.charAt(l)) > 1)
                    store2.put(s2.charAt(l),store2.get(s2.charAt(l))-1);
                else
                    store2.remove(s2.charAt(l));
            }

            l++;
        }

        return false;
    }
    
    
    private boolean compare() {
        
        if(store1.size() != store2.size()){
            return false;
        }
        
       return store1.equals(store2);
    }
}