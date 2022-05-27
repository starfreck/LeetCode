**Follow up:**
1. What if the given array is already sorted? How would you optimize your algorithm?  
Answer: No need to sort the input arrays, It will save O(n log n) and final time complixity would be O(n).
2. What if nums1's size is small compared to nums2's size? Which algorithm is better?  
Answer: Start with the smaller one, It will finish faster.
3. What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?  
Answer: Start with the small chunk of nums2. (or one could use skip pointers?)
