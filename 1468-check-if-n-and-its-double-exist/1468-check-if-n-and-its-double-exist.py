class Solution:
    # TC: O(n)
    # SC: O(n)
    def checkIfExist(self, arr: List[int]) -> bool:
        twice = {}
        for i in range(0,len(arr)):
            twice[2*arr[i]] = i
        for i in range(0,len(arr)):
            if arr[i] in twice:
                if i != twice[arr[i]]:
                    return True
        return False
            
