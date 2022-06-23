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
    
    long preValue = Long.MIN_VALUE;
    boolean flag = true;
    
    public boolean isValidBST(TreeNode root){
        
        // O(n)
        isValidBST(root,null,false);            
        return flag;
    }
    
    public void isValidBST(TreeNode node, TreeNode parent, boolean isRight) {
        
        if(node == null || flag == false) {
            return;
        }
        
        // Right Node
        if (parent != null && isRight && node.val <= parent.val) {
           flag = false; 
        // Left Node
        } else if(parent != null && !isRight && node.val >= parent.val) {
            flag = false;
        }
        
        // In Order
        isValidBST(node.left, node, false);
        
        
        if(preValue < node.val) {
            preValue = node.val;
            System.out.println(preValue);
        } else if(preValue == Long.MIN_VALUE){
            preValue = node.val;
            System.out.println(preValue);
        } else {
            flag = false;
        }
        
        isValidBST(node.right, node, true);
        
    }
}
// Time Complexity: O(n) - visiting all nodes once
// Space Complexity: O(log n) - stack size will be same as the height of the tree