/** Traverse the tree inorder, we would be going bottom to top.
 * If previous value was greater, than the tree in not valid
 * Time complexity: O(N)
 * Space complexity: O(H)
 */

class Solution {
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        /* Iterative inorder traversal */
        TreeNode prev = null;
        
        while(!stack.empty() || root!=null)
        {
            while(root!=null)
            {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(prev!=null && prev.val>=root.val)
                return false;
            prev=root;
            root = root.right;
        }
        return true;
    }
}