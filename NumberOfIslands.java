/*Approach: 
1. Add all the 1st 1 you come accross to the queue, convert this element to something that is not on the matrix, so '2' - marking it as visited
and traverse its childern at once - BFS, converting all its neighbhoring 1's into something else and increment the count for this level
2. Then move on to next 1 in the matrix - keeping in mind that the nieghbhors for the 1st 1 have already been marked to a non 1 value
and repeat the steps 

Space complexity: O(MN) - worst case
Time complexity: O(MN)
*/

class Solution {
    int islands = 0;
    int[][] directions = new int[][]{{-1,0}, {1,0}, {0,-1}, {0,1}};
    public int numIslands(char[][] grid) {
        for(int i=0; i<=grid.length-1; i++)
        {
            for(int j=0; j<= grid[0].length-1; j++)
            {
                if(grid[i][j]=='1')
                {
                    islands+=1;
                    traverse(grid, i, j);
                }
            }
        }
        return islands;
    }
    
    private void traverse(char[][] grid, int i, int j)
    {
        if(i>=0 && i<=grid.length-1 && j>=0 && j<=grid[0].length-1 && grid[i][j]=='1')
        {
            grid[i][j]='2';
            for(int[] dir: directions)
            {
                int r = i+dir[0];
                int c = j+dir[1];
                traverse(grid,r,c);
            }
        }
        else
            return;
    }
}