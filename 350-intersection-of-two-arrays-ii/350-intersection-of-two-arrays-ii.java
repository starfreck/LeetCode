class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        List result = new ArrayList<Integer>();
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int[] first;
        int[] second;
        
        if(nums1.length > nums2.length){
            first = nums2;
            second = nums1;
        } else{
            first = nums1;
            second= nums2;
        }
        
        int one = 0, two = 0;
        
        
        // Do the Intersection
        while(one < first.length && two < second.length){
            
            if(first[one] == second[two]){
                result.add(first[one]);
                one++;
                two++;
            } else if(first[one] > second[two]){
                two++;
            } else {
                one++;
            }
        }
        
        int[] resultArr = new int[result.size()];
        
        for(int k=0; k < result.size(); k++){
            resultArr[k] = (Integer) result.get(k);
        }
        
        return resultArr;
        
    }
}