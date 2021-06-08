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
1. Start off with adding the root element to the queue
2. Process the tree in level wise manner / BFS - adding left node to the queue first and right later on 
3. While being on the same level, add the element to the result only if it is the last element for the level 

Time complexity: O(N)
Space complexity: O(N)
*/
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        
        if(root==null) return result;
        else queue.add(root);
        
        while(!queue.isEmpty())
        {
            int size = queue.size();
            for(int i=0; i<=size-1; i++)
            {
                TreeNode currentNode = queue.remove();
                if(i==size-1) result.add(currentNode.val);
                if(currentNode.left!=null) queue.add(currentNode.left);
                if(currentNode.right!=null) queue.add(currentNode.right);
            }
        }
        return result;
    }
}