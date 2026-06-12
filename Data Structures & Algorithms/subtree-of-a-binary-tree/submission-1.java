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
        if(subRoot == null) return true;
        if(root == null) return false;

        if(root.val == subRoot.val && isSame(root, subRoot)){
            return true;
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public boolean isSame(TreeNode rootA, TreeNode rootB){
        if(rootA == null && rootB == null){
            return true;
        }

        if(rootA == null || rootB == null || rootA.val != rootB.val){
            return false;
        }

        return isSame(rootA.left, rootB.left) && isSame(rootA.right, rootB.right);
    }
}
