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
    
    Map<Integer,Integer> map = new HashMap<>();
    
    List<Integer> result = new ArrayList<>();
    
    public List<Integer> rightSideView(TreeNode root) {
        
        rightSideView(root,0);
        
        for(int i = 0; i < map.size(); i++){
            result.add((int)map.get(i));      
        }
        
        return result;
    }
    
    public void rightSideView(TreeNode node, int level){
        
        if(node == null){
            return;
        }
        
        
        // Keep Updating the Map
        map.put(level,node.val);
        
        rightSideView(node.left, level+1);
        rightSideView(node.right, level+1);
    }
}
// Time Complexity: O(n)
// Space Complexity: O(log n)