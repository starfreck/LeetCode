class Solution:
    def sortArray(self, nums: List[int]) -> List[int]:
        
        
        def merge(array, start, mid, end):
            array_index = start
            left_index = right_index = 0
            left, right = array[ start: mid + 1 ], array[ mid + 1 : end + 1 ]

            while left_index < len(left) and right_index < len(right):
                if left[left_index] >= right[right_index]:
                    array[array_index] = right[right_index]
                    right_index += 1
                else:
                    array[array_index] = left[left_index]
                    left_index += 1
                array_index += 1

            while left_index < len(left):
                array[array_index] = left[left_index]
                left_index += 1
                array_index += 1
                
            while right_index < len(right):
                array[array_index] = right[right_index]
                right_index += 1
                array_index += 1

        def mergeSort(array, start, end):
            if start == end:
                return
            mid = (start + end) // 2
            mergeSort(array, start, mid)
            mergeSort(array, mid+1, end)
            merge(array, start, mid, end)
            return array

        return mergeSort(nums, 0, len(nums))