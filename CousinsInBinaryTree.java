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
/*Approach:
1. The nodes would be cousins if their depth is the same from the 1st root but they don't have the same parent 
2. Traverese the tree in bfs and store the depth and the parent for the nodes (by matching their values with the node we are at)
3. When done traversing, verify that the depth should be the same and the parents should be different 

Time complexity: O(N)
Space complexity: O(N)
*/
class Solution {
    int depth1 = 0;
    int depth2 = 0;
    TreeNode parent1 = null;
    TreeNode parent2 = null;
    
    public boolean isCousins(TreeNode root, int x, int y) {
        inorder(root, 0, x, y, null);
        if(depth1==depth2 && parent1!=parent2)
            return true;
        else
            return false;
    }
    
    private void inorder(TreeNode root, int height, int x, int y, TreeNode parent)
    {
        if(root==null)
            return;
        if(root.val == x)
        {
            depth1 = height;
            parent1 = parent;
        }
        if(root.val == y)
        {
            depth2 = height;
            parent2 = parent;
        }
        inorder(root.left, height+1, x, y, root);
        inorder(root.right, height+1, x, y, root);
    }
}