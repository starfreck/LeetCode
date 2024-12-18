class Solution:
    # TC: O(m*n) where 'm' is length of 'word1' and 'n' is the length of 'word2' 
    # SC: O(m*n) where 'm' is length of 'word1' and 'n' is the length of 'word2'
    def mergeAlternately(self, word1: str, word2: str) -> str:
        res = ''
        i = j = count = 0
        
        while i < len(word1) or j < len(word2):
            if i < len(word1):
                res = res + word1[i]
                i += 1
            if j < len(word2):
                res = res + word2[j]
                j += 1

        return res