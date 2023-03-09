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
    
    public List<Integer> postorderTraversal(TreeNode root) {
        result = new ArrayList<>();
        postOrder(root);
        return result;
    }
    
    private void postOrder(TreeNode node){
        if(node == null){
            return;
        }

        
        // Visit Left node
        postOrder(node.left);
        // Visit Right node
        postOrder(node.right);
        // Visit Middle node
        result.add(node.val);

    }

    // Time Complexity: O(n log n)
    // Space Complexity: O(1)
}