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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null)
        return root;

        if(root.val==key)
        return connection(root);

        TreeNode mainRoot=root;

        while(root!=null){
            if(root.val>key){
                if(root.left!=null && root.left.val==key)
                root.left=connection(root.left);
                else
                root=root.left;
            }
            else if(root.right!=null && root.right.val==key)
            root.right=connection(root.right);
            else
            root=root.right;
        }
        return mainRoot;
    }
    public TreeNode connection(TreeNode root){
        if(root.left==null)
        return root.right;
        if(root.right==null)
        return root.left;

        TreeNode rightMost=findRight(root.left);
        rightMost.right=root.right;

        return root.left;
    }

    public TreeNode findRight(TreeNode root){
        if(root.right==null)
        return root;

        return findRight(root.right);
    }
}