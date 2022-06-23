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
    
    List<Integer> result = new ArrayList<>();
    
    public List<Integer> rightSideView(TreeNode root) {
        
        rightSideView(root,0);
        
        return result;
    }
    
    public void rightSideView(TreeNode node, int level){
        
        if(node == null){
            return;
        }
        
        if(level == result.size()){
            result.add(node.val);
        }
        
        rightSideView(node.right, level+1);
        rightSideView(node.left, level+1);
    }
}
// Time Complexity: O(n)
// Space Complexity: O(log n)