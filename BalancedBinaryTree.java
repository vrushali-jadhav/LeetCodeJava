/* Appoarch: keep checking if the left and the right tree is the balanced or not at all times. 
Also keep checking that the height difference is not more than 1.

Time complexity: O(N)
Sapce complexity: O(1)
*/
class Solution {
    public boolean isBalanced(TreeNode root) {
       if(root==null) return true;
       boolean leftBalanced = isBalanced(root.left);
       boolean rightBalanced = isBalanced(root.right);
       boolean heightOkay = Math.abs(height(root.left)-height(root.right))<=1;
       return leftBalanced && rightBalanced && heightOkay;
    }

    private int height(TreeNode root)
    {
        if(root==null) return 0;
        else
            return Math.max(height(root.left),height(root.right))+1;
    }
}