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
/*
Idea is we create a tree node from the preorder traversal and do 
a dfs for all nodes on the left half of it in the inorder sequence
and another dfs for all nodes on the right. In a inorder seq, all nodes
to thr left of a node belongs to it's left subtree and on the right
to it's right subtree. As for the limit, since this is BST, root.val
is the limit for all nodes in the left subtree and infinity is the limit
for all nodes to the right
*/
class Solution {
    private int preIdx, inIdx;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preIdx = 0;
        this.inIdx = 0;
        return dfs(preorder, inorder, Integer.MAX_VALUE);
    }

    public TreeNode dfs(int[] preorder, int[] inorder, int limit){
        if(preIdx >= preorder.length){
            return null;
        }

        if(inorder[inIdx] == limit){
            inIdx++;
            return null;
        }

        TreeNode root = new TreeNode(preorder[preIdx++]);
        root.left = dfs(preorder, inorder, root.val);
        root.right = dfs(preorder, inorder, limit);

        return root;
    }
}
/*
TC: O(n), SC: O(n)
*/