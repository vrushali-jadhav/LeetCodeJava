/*Approach:
We will process the matrix in BFS. The 1st level would be all the 0's (independent nodes).
The second level would process all the nieghhors of 0s. So we don't have to maintain the minimum distance. 
We will just us the distance calculate on level before the current 1 and use that value. 
So the distance for elements on current level would be the distance on the previous level+1

We don't need to maintain the size over here, because the distance will be 0 for element that is 0 anyway. And we added all the 0's in the queue base condition.

Time complexity: O(MN)
Space complexity: O(MN)

The other approach could have been starting out with any element in the queue (probably 1). But that would require reaching/looking for 0 for every element. 
Which would make the TC almost O(MN*MN)
*/

class Solution {
    Queue<int[]> queue = new LinkedList<>();
    public int[][] updateMatrix(int[][] mat) {
        for(int i=0; i<=mat.length-1; i++)
        {
            for(int j=0; j<= mat[0].length-1; j++)
            {
                if(mat[i][j]==0)
                    queue.add(new int[]{i,j});
                else
                    mat[i][j]=-1;
            }
        }
        
        int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};
        
        int distance = 0; 
        while(!queue.isEmpty())
        {
            int[] currentElement = queue.remove();
            distance = mat[currentElement[0]][currentElement[1]];
            for(int[] dir: directions)
            {
                int r = currentElement[0]+dir[0];
                int c = currentElement[1]+dir[1];

                if(r<=mat.length-1 && r>=0 && c<=mat[0].length-1 && c>=0 && mat[r][c]==-1)
                {
                    mat[r][c] = distance+1;
                    queue.add(new int[]{r,c});
                }
            }
        }
        return mat;
    }
}