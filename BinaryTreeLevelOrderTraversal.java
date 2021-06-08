/*Approach1: Traverse the tree BFS. Use queue to do so. 
1. To clearly identify nodes on the same level, use a count.
2. Get the root from the queue and add its child if they aren't null

Time complexity: O(N)
Space complexity: O(N)

class Solution {
    Queue<TreeNode> queue = new LinkedList<>();
    List<List<Integer>> result = new ArrayList<>();
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null)
            return result; 
        
        queue.add(root);
        while(!queue.isEmpty())
        {
            ArrayList<Integer> levelList = new ArrayList<>();
            int i = 0;
            int size=queue.size();
            while(i<size)
            {
                TreeNode currentRoot = queue.remove();
                levelList.add(currentRoot.val);
                if(currentRoot.left!=null)
                    queue.add(currentRoot.left);
                if(currentRoot.right!=null)
                    queue.add(currentRoot.right);
                i++;
            }
            result.add(levelList);
        }
        return result;
    }
}
*/
/*Approach: Maintain the levels in the recursive stack by adding the level as a parameter to teh recrsive call

Time complexity: O(N)
Space complexity: O(1)
*/
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null)
            return result; 
        preorder(root, 0);
        return result;
    }
    
    private void preorder(TreeNode root, int level)
    {
        if(root==null)
            return;
        //logic 
        if(result.size()<=level) //if the list is not present for the level, create a list and add 
            result.add(new ArrayList<>());
        //at this point, a list for the level is definetly present (could still be empty)
        result.get(level).add(root.val); //get the existing list and add current root to it
        //processing nodes
        preorder(root.left, level+1);
        preorder(root.right, level+1);
    }
}