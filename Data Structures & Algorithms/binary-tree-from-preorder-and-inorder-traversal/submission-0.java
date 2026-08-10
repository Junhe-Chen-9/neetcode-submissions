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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        // root == preorder[0]
        TreeNode root = new TreeNode(preorder[0]);
        int mid = -1;
        // left range is inorder 0 -> root
        // right range is after root 0 end on inorder
        for(int i = 0; i < inorder.length; i ++){
            if(inorder[i] == root.val){
                // this is our mid piont
                // left is the left tree
                // right is the right tree
                mid = i;
                break;
            }
        }
        // now we search the mid indx on the pre prder also 
        int[] leftPreOrder = Arrays.copyOfRange(preorder,1,mid + 1);
        int[] leftInorder = Arrays.copyOfRange(inorder,0,mid);
        root.left = buildTree(leftPreOrder,leftInorder);
        
        int[] rightPreorder = Arrays.copyOfRange(preorder, mid + 1, preorder.length);
        int[] rightInorder = Arrays.copyOfRange(inorder, mid + 1, inorder.length);
        root.right = buildTree(rightPreorder, rightInorder);

        return root;

    }
}
