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

    public List<Integer> inorderTraversal(TreeNode root) {
        result = new ArrayList<>();
        inOrder(root);
        return result;
    }

    private void inOrder(TreeNode node){
        if(node == null){
            return;
        }

        // Visit Left node
        inOrder(node.left);
        // Visit Middle node
        result.add(node.val);
        // Visit Right node
        inOrder(node.right);

    }

    // Time Complexity: O(n log n)
    // Space Complexity: O(1)
}