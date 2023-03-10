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
    
    Queue q = new PriorityQueue<Integer>();
    
    public int kthSmallest(TreeNode root, int k) {
        
        inOrder(root);
        
        while(k-2 >= 0){
            q.poll();
            k--;
        }
        
        return (int) q.peek();
    }
    
    private void inOrder(TreeNode node) {
        
        if(node == null){
            return;
        }
        
        inOrder(node.left);
        q.add(node.val);
        inOrder(node.right);
    }
}
// Time Complexity: O(n log n)
// Space Complexity: O(n)