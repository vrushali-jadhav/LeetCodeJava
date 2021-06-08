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
/* Approach:
1. Store the level as the local stack variable by making it a parameter in the method
2. Result will have the max element for that level, level will be used as index to get the max element for that level
3. So the main root's index in the result list would be 0
4. Traverse through the list in DFS, preorder, if the value for the level is not present, add it or else replace it if it is bigger

Time complexity: O(N)
Space complexity: O(N)
*/
public class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList();
        if(root==null) return result;
        result.add(root.val);
        helper(root, result, 0);
        return result;
    }

    void helper(TreeNode root, List<Integer> result, int level){
        if(root==null) return;
        if(result.size()==level) 
            result.add(root.val);
        else if(root.val > result.get(level)) 
            result.set(level, root.val);
        helper(root.left, result, level+1);
        helper(root.right, result, level+1);
    }
}