/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    
    TreeNode result;
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        inOrder(root,p,q);
        return result;
    }
    
    private void inOrder(TreeNode node, TreeNode p, TreeNode q) {
        
        if(node == null){
            return;
        } 
        
        // Search Left
        if(node.val > p.val && node.val > q.val)
        {
            inOrder(node.left,p,q);
        }
        // Search Right
        else if(node.val < p.val && node.val < q.val)
        {
            inOrder(node.right,p,q);
        }
        else
        {
            result = node;
        }
        
    }
}
// Time Complexity: O(n log n)
// Space Complexity: O(1)