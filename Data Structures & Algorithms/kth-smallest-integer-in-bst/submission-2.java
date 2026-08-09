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
        flatTree(root,k);
        return list.get(k - 1);
    }
    private void flatTree(TreeNode root, int k){
        if(root == null) return;
        if(list.size() == k) return;
        flatTree(root.left,k);
        list.add(root.val);
        flatTree(root.right,k);
    }
}
