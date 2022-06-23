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
    
    // O(n)
    ArrayList<Integer> list = new ArrayList<>();
    
    public boolean isValidBST(TreeNode root){
        
        // O(n)
        isValidBST(root,null,false);
        
        if(flag) {
            // O(n)
            for(int i = 1; i < list.size(); i++) {
                if(list.get(i) > list.get(i-1)) {
                    continue;
                } else {
                    flag = false;
                }
            }
        }
            
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
        list.add(node.val);
        isValidBST(node.right, node, true);
        
    }
}
// Time Complexity: O(n) - visiting all nodes once
// Space Complexity: O(log n) - stack size will be same as the height of the tree