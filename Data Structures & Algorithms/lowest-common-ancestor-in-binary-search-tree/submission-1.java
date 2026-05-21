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
    /*
    Since this is a BST, we need to worry about these three conditions:
    1. If p.val and q.val < root.val, move to root.left (left child)
    2. else if p.val and q.val > root.val, move to root.right (right child)
    3. else root is the LCA, return it
    */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;

        if(p.val < root.val && q.val < root.val){
            return lowestCommonAncestor(root.left, p, q);
        }
        else if(p.val > root.val && q.val > root.val){
            return lowestCommonAncestor(root.right, p, q);
        }

        return root;
    }
}
/*
Since we are cutting the search space to half at every recursion,
TC = O(h) where h=height of the tree (if tree is skewed, O(h) = O(n), 
for balanced BST O(h) = O(log n))
SC = O(h) for the recursive stack
*/
