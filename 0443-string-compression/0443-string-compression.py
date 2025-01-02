class Solution:
    # TC: O(n)
    # SC: O(1)
    def compress(self, chars: List[str]) -> int:
        ptr = 0
        charCount = 1
        i = 1
        while i <= len(chars):
            if i == len(chars):
                chars[ptr] = chars[i-1]
                ptr += 1
                if charCount > 1:
                    for c in str(charCount):
                        chars[ptr] = c
                        ptr += 1
                break
            if chars[i-1] == chars[i]:
                charCount += 1
            else:
                chars[ptr] = chars[i-1]
                ptr += 1
                if charCount > 1:
                    for c in str(charCount):
                        chars[ptr] = c
                        ptr += 1
                charCount = 1
            i += 1
        return ptr