class Solution:
    
    # SC: O(n) -> We are storing the final string into result wehich is size od input string
    # TC: O(n) -> We are itrating over the number of indexes where spaces needs to be added
    def addSpaces(self, s: str, spaces: List[int]) -> str:
        result = str()
        start,end = 0,0
        for space in spaces:
            end = space
            result = result + s[start:end] + " "
            start = space
        return result + s[start:]


    # SC: O(n)
    # TC: O(n)
    # TLE
    def addSpacesS2(self, s: str, spaces: List[int]) -> str:
        new = list(s)
        itr = 0
        for space in spaces:
            index = space + itr
            new.insert(index, " ")
            itr += 1
        return "".join(new)

    # SC: O(n)
    # TC: O(n)
    # TLE
    def addSpacesS1(self, s: str, spaces: List[int]) -> str:
        result = []
        for i in range(0, len(s)):
            if i in spaces:
                result.append(" ")
            result.append(s[i])
        return "".join(result)

