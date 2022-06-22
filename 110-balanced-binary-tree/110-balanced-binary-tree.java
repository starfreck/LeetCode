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
    
    boolean flag = true;
    
    public boolean isBalanced(TreeNode root) {
        
        Helper(root,0);
        
        return flag;
    }
    
    public int Helper(TreeNode node, int height){
        
        if(node == null){
            return height-1;
        }
        
        
        int leftSubTreeHeight = Helper(node.left, height+1);
        int rightSubTreeHeight = Helper(node.right, height+1);
        
        if(Math.abs(leftSubTreeHeight-rightSubTreeHeight) >= 2){
            flag = false;
        }
        
        return Math.max(leftSubTreeHeight,rightSubTreeHeight);
    }
}
// Time Complexity: O(log n)
// Space Complexity:O(n) - in Memory Stack