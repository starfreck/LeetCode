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
    
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return helper(p,q);
    }
    
    private boolean helper(TreeNode node1,TreeNode node2){
        
        if(!flag){
            return flag;
        }
        
        if(node1 == null && node2 == null){
            return true;
        }
        

        if(node1 != null && node2 != null && node1.val == node2.val){
            
            boolean left = helper(node1.left, node2.left);
            boolean right = helper(node1.right, node2.right);
            
            if(left && right){
                return true;
            }
        }
        
        return false;
    }
    
}
// Time Complexity: O(n) - we are visiting each node once.
// Space Complexity: O(log n) - in Memory Stack - The Sack can max goes up to the max height of the tree.