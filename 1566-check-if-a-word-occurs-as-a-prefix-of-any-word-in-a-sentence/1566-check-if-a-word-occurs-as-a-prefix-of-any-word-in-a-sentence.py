class Solution:
    # TC: O(n) where n is the number of words to itrate over
    # SC: O(n) where n is number of words to store in a list
    def isPrefixOfWord(self, sentence: str, searchWord: str) -> int:
        result = -1
        words = sentence.split(" ")
        for index in range(0,len(words)):
            if words[index].startswith(searchWord):
                result = index+1
                break
        return result
    