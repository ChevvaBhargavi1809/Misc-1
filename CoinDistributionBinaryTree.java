// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Approach : Use dfs traversal to compute number of extra coins at a node as extraCoins(from left subtree)+extraCoins(right subtree)
/// + coins at current node -1. Total number of moves (min) = math.abs(extraCoins) at each node
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
    int moves;
    public int distributeCoins(TreeNode root) {
        dfs(root);
        return moves;
    }
    public int dfs(TreeNode root){
        if(root==null){
            return 0;
        }
        int extra = root.val;
        extra += dfs(root.left);
        extra += dfs(root.right);
        moves += Math.abs(extra-1);
        return extra -1;
    }
}