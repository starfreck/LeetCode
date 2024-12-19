# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:

    """
    The solution which I can think by looking at the problem
    is to traverse a tree in pre-order with keeping track of all
    nodes on the each level in map and return the list of 
    nodes' val on each level. Since the right nodes are visted in
    the last in pre-order traversal eventually all levels will be
    overwritten by right nodes. 
    """
    # TC: O(n) since we are visting all nodes once
    # SC: O(log n) since we are storing only 1 node's value on each level in a tree
    # and the heigh of tree is log n so eventuallly we will store log n elements.
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        levels = {}
        def preOrderVisit(node: TreeNode, level: int):
            if node == None:
                return
            # Visit left sub-tree    
            preOrderVisit(node.left, level+1)
            # Visit root node
            levels[level] = node.val
            # Vist right sub-tree
            preOrderVisit(node.right, level+1)

        preOrderVisit(root,0)
        return [levels[i] for i in range(0,len(levels))]