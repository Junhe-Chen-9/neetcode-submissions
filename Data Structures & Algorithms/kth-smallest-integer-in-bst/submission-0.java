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
    List<Integer> list = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        // you want to look left then your self and then right;
        flatTree(root);
        return list.get(k - 1);
    }
    private void flatTree(TreeNode root){
        if(root == null) return;
        flatTree(root.left);
        list.add(root.val);
        flatTree(root.right);
    }
}
