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
    
    HashMap<Integer,List<Integer>> map = new HashMap<>();
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
            
        helper(root,0);
        
        for(int i = 0; i < map.size(); i++){
            
            result.add((List<Integer>) map.get(i));
            
        }
        
        return result;
    }
    
    public void helper(TreeNode node, int level){
         
        if(node != null){
            
            put(level,node.val);
            helper(node.left,level+1);
            helper(node.right,level+1);
        }
        
    }
    
    public void put(int level, int value){
        
        List<Integer> list;
        
        if(map.get(level) != null){
            list = (List<Integer>) map.get(level);
            list.add(value);
            return;    
        }
        
        list = new ArrayList<Integer>();
        list.add(value);
        map.put(level,list);
    }
}