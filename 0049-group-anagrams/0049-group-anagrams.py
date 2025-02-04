class Solution:
    # TC: O(m * n) where m is number of strings and n is 26 so O(n)
    # SC: O(m)
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        result = {}
        for string in strs:
            key = self.createKey(string)
            if key not in result:
                result[key] = list()
            result[key].append(string)
        return list(result.values())

    def createKey(self, s):
        l = [0]*26
        key = ""
        for c in s:
            l[ord(c) - ord('a')] += 1
        for i in range(len(l)):
            if l[i] >= 1:
                key += (chr(i + ord('a')) + str(l[i]))
        return key