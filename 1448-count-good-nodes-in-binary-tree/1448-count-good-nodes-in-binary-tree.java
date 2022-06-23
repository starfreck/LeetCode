/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    
    
    int goodNodesCount = 0;
    
    public int goodNodes(TreeNode root) {
        int max = Integer.MIN_VALUE;
        return goodNodes(root,max);
    }
    
    private int goodNodes(TreeNode root, int max) {
        
        if(root == null){
            return goodNodesCount;
        }
        
        if(root.val >= max){
            max = root.val;
            goodNodesCount++;
        }
        
        goodNodes(root.left, max);
        goodNodes(root.right, max);
        
        return goodNodesCount;

    }
}
// Time Complexity: O(n) - Visiting all nodes once
// Space Complexity: O(log n) - Max size of in-memory stack will be the same as height of the tree