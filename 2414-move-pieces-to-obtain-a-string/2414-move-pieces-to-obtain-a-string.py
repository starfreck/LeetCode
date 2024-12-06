class Solution:
    # TC: O(N)
    # SC: O(1)
    # Two pointer approach
    # L can only move left side and R can only move on right side, we can ignore all '_'
    # according to above if L can only move left then the postion for all L's in target string would be either equal (in case there ewas no space) or less than the start position
    # same thing can be applied for all Rs but it would be equal or greater than the starting position
    def canChange(self, start: str, target: str) -> bool:
        # Check if the L and R has the same order and count
        start_str, target_str = "", ""
        for z in range(len(start)):
            if start[z] != '_':
                start_str += start[z]
            if target[z] != '_':
                target_str += target[z]
        if start_str != target_str:
            return False
                
        i,j = 0,0
        while i < len(start) and j < len(target):
            # check the char in start
            if start[i] == '_':
                i+=1
                continue
            # check the char in target
            if target[j] == '_':
                j+=1
                continue
            # Check if char are same
            if start[i] != target[j]:
                print("1")
                return False
            else:
                if start[i] == 'L':
                    # check if target L's position is less than or equal start L's position
                    if j <= i:
                        i+=1
                        j+=1
                        continue
                    else:
                        print("2")
                        return False
                elif start[i] == 'R':
                    # check if target R's position is greater than or equal start R's position
                    if j >= i:
                        i+=1
                        j+=1
                        continue
                    else:
                        print("3")
                        return False
        return True
        
