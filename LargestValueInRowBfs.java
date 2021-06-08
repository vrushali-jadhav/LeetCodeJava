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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root==null)
            return results;
        queue.add(root);

        //process the queue
        while(!queue.isEmpty())
        {
            int size = queue.size();
            Integer maxElement=null;
            //process each level
            for(int i=0; i<= size-1 ; i++) {
                //current root
                TreeNode currentRoot = queue.remove();
                if(maxElement==null || maxElement<currentRoot.val)
                    maxElement = currentRoot.val;
                if(currentRoot.left!=null)
                    queue.add(currentRoot.left);
                if(currentRoot.right!=null)
                    queue.add(currentRoot.right);
            }
            results.add(maxElement);
        }
        return results;
    }
}