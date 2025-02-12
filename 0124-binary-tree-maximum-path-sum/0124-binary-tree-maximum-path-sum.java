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

    private int result = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        Recursion(root);
        return result;
    }

    private int Recursion(TreeNode node){
        
        if(node == null){
            return 0;
        }

        int l = Recursion(node.left);
        int r = Recursion(node.right);

        int tmp = Math.max(Math.max(l,r)+node.val, node.val);
        int ans = Math.max(tmp, l + r + node.val);
        result = Math.max(ans, result);

        return tmp;

    }
}