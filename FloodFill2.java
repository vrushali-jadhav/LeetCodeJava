/*Approach: 
1. Record the color of the starting pixel, change it to the new color and addit to queue
2. Now use the queue to traverese all the side cells of the cell present in the queue and change the color if it matches the starting color. 
3. If it matched the starting color, replace its color and add it to queue
4. A cell from the queue will be processed in all 4 directions

Time complexity: APPROXIMATELY: O(N)
Space complexity: Approximately O(N)
*/
class Solution {
    Queue<int[]> queue = new LinkedList<>();
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int startingColor = image[sr][sc];
        
        image[sr][sc]=newColor;
        if(startingColor==newColor)
            return image;
        queue.add(new int[]{sr,sc});
        
        while(!queue.isEmpty())
        {
            int[] currentElement = queue.remove();
            int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};
            
            for(int[] dir: directions)
            {
               int r = currentElement[0]+dir[0];
               int c = currentElement[1]+dir[1];
             
               if(r<=image.length-1 && r>=0 && c<=image[0].length-1 && c>=0)
               {
                   if(image[r][c]==startingColor)
                   {
                       image[r][c]=newColor;
                       queue.add(new int[]{r,c});
                   }
               }
            }
        }
        return image;
    }
}