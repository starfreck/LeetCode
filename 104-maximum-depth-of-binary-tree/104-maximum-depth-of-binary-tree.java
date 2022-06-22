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
    
    public int maxDepth(TreeNode root) {
        
        return maxDepthHelper(root,0);
    }
    
    private int maxDepthHelper(TreeNode node, int depth){
        
        if(node == null){
            return depth;
        }
        
        int left = maxDepthHelper(node.left, depth+1);
        int right = maxDepthHelper(node.right, depth+1);
        
        return Math.max(left,right);

    }
}
// Time Complexity: O(log n)
// Space Complexity:O(n)