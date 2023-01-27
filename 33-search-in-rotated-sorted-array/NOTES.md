First do a binary search to find the pivot:
​
* Step 1
compare mid pointer to right most value on the array. If value in mid pointer is greater than right most value in array, we know the pivot is to the right of the mid pointer. If value at mid pointer is smaller than right most value in the array, we know that the pivot is to the left. Split array in half until your left and right pointers touch.
* Step 2
Do a 2nd binary search on the whole array. This time we are looking for the target, not a pivot. Now that we know our pivot we just need to modify our midvalue like so: realMid = (mid + pivot) % nums.Length;
​  

Complexity of 2 binary searches is O ( 2 Log (n)) which is O (Log(n))
