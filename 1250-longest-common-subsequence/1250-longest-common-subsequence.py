class Solution:
    
    def longestCommonSubsequence(self, text1: str, text2: str) -> int:
        self.t = [[-1 for x in range(len(text2)+1)] for y in range(len(text1)+1)]
        return self.lcs(text1, text2, len(text1), len(text2))

    def lcs(self, text1: str, text2: str, l1: int, l2: int) -> int:
        if l1 == 0 or l2 == 0:
            return 0
        if self.t[l1][l2] != -1:
            return self.t[l1][l2]

        if text1[l1-1] == text2[l2-1]:
            self.t[l1][l2] = 1 + self.lcs(text1, text2, l1-1, l2-1)
            return self.t[l1][l2]
        else:
            s1 = self.lcs(text1, text2, l1-1, l2)
            s2 = self.lcs(text1, text2, l1, l2-1)
            self.t[l1][l2] =  max(s1,s2)
            return self.t[l1][l2]