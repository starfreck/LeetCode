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
    public TreeNode invertTree(TreeNode root) {
        return invertTreeHelper(root);
    }
    
    private TreeNode invertTreeHelper(TreeNode node){
        
        if(node == null){
            return node;
        }
        
        TreeNode left = node.left;
        TreeNode right = node.right;
        
        
        node.right = invertTreeHelper(left);
        node.left = invertTreeHelper(right);
        
        return node;
    }
}
// Time Complexity: O(log n) - Height of tree is log n
// Space Complexity: O(n)