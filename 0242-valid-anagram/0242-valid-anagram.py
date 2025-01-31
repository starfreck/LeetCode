class Solution:

    # TC: O(m+n)
    # SC: O(1) since we know that s and t consist of lowercase English letters. O(26)
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False
            
        m1, m2 = {}, {}
        for i in range(len(s)):
            m1[s[i]] = 1+ m1.get(s[i],0)
            m2[t[i]] = 1+ m2.get(t[i],0)
        return m1 == m2