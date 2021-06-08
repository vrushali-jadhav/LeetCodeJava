class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();
    int index=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //emtpty tree
        if(preorder.length==0)
            return null;
        
        for(int i=0; i<=inorder.length-1; i++)
        {
            map.put(inorder[i],i);
        }
        
        return constructTree(preorder, inorder, 0, inorder.length-1);
    }
    
    private TreeNode constructTree(int[] preorder, int[] inorder, int start, int end)
    {
        if(start>end) return null;
        int rootIndex = map.get(preorder[index]);
        TreeNode root = new TreeNode(preorder[index]);
        index++;
        root.left = constructTree(preorder, inorder, start, rootIndex-1);
        root.right = constructTree(preorder, inorder, rootIndex+1, end);
    
        return root;
    }
}