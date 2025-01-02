# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:

    # TC: O(m+n) where 'm' and 'n' is number of nodes in tree1 and tree2 respectivly
    # SC: O(a+b) where 'a' and 'b' is number of leaf nodes in tree1 and tree2 respectivly
    def leafSimilar(self, root1: Optional[TreeNode], root2: Optional[TreeNode]) -> bool:
        tree1LeafValueSeq = []
        tree2LeafValueSeq = []
        
        self.preTraversal(root1, tree1LeafValueSeq)
        self.preTraversal(root2, tree2LeafValueSeq)

        return tree1LeafValueSeq == tree2LeafValueSeq


    def preTraversal(self, root: Optional[TreeNode], leafValues: List[int]):
        if root == None:
            return
        if root.left == None and root.right == None:
            leafValues.append(root.val)
            return
        self.preTraversal(root.left, leafValues)
        self.preTraversal(root.right, leafValues)