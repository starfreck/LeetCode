class Solution:
    # TC: O(n)
    # SC: O(1)
    def canMakeSubsequence(self, str1: str, str2: str) -> bool:
        i,j = 0,0
        while i < len(str1) and j < len(str2):
            if str1[i] == str2[j]:
                i += 1
                j += 1
                continue
            # Increment
            new_char = '!'
            if str1[i] == 'z':
                new_char = 'a'
            else:
                new_char = chr(ord(str1[i])+1)
            # compare
            if new_char == str2[j]:
                i += 1
                j += 1
            else:
                i+=1

        if j == len(str2):
            return True
        return False