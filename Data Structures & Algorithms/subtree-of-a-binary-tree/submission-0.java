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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // base case 
        if(root == null && subRoot == null) return true;
        if(subRoot == null) return true;
        if(root == null) return false;
        if(root.val == subRoot.val){
            if(isSameTree(root,subRoot)) return true;
        }
        boolean left = isSubtree(root.left,subRoot);
        boolean right = isSubtree(root.right,subRoot);
        return left || right;
    }
    private boolean isSameTree(TreeNode root, TreeNode node){
        // base case 
        if(root == null && node == null) return true;
        if(root == null || node == null) return false;
        if(root.val != node.val) return false;
        return isSameTree(root.left,node.left) && isSameTree(root.right,node.right);
    }
}
