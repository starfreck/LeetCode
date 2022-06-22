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
    
    boolean flag = false;
    
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        helper(root, subRoot);
        return flag;
    }
    
    private void helper(TreeNode node, TreeNode subNode){

        if(node == null || flag){
            return;
        }
        
        if(subNode != null && node.val == subNode.val){
            flag = subHelper(node,subNode);
        }
        
        helper(node.left, subNode);
        helper(node.right, subNode);
    }
    
    
     private boolean subHelper(TreeNode node1,TreeNode node2){
        
        if(flag){
            return flag;
        }
        
        if(node1 == null && node2 == null){
            return true;
        }
        

        if(node1 != null && node2 != null && node1.val == node2.val){
            
            boolean left = subHelper(node1.left, node2.left);
            boolean right = subHelper(node1.right, node2.right);
            
            if(left && right){
                return true;
            }
        }
        
        return false;
    }
   
}
// Time Complexity:
// Space Complexity: