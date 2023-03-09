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
    
    List<Integer> result;
    
    public List<Integer> preorderTraversal(TreeNode root) {
        result = new ArrayList<>();
        preOrder(root);
        return result;
    }
    
    private void preOrder(TreeNode node){
        if(node == null){
            return;
        }

        // Visit Middle node
        result.add(node.val);
        // Visit Left node
        preOrder(node.left);
        // Visit Right node
        preOrder(node.right);

    }

    // Time Complexity: O(n log n)
    // Space Complexity: O(1)
}