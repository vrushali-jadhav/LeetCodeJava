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
        if(startingColor==newColor)
            return image;
        helper(image, sr, sc, newColor, startingColor);
        return image;
    }
    
    private void helper(int[][] image, int sr, int sc, int newColor, int startingColor)
    {
        //base
        if(sr>=image.length || sr<0 || sc>=image[0].length || sc<0 || image[sr][sc]!=startingColor) //if the bounds are crossed or if the color of the cell doesn't match the starting color
            return;
        else
            image[sr][sc]=newColor; //it is equal to the starting color, so juts update it to the new color
        
        //logic
        //call the recursive call in all directions 
        helper(image, sr-1, sc, newColor, startingColor); //up
        helper(image, sr+1, sc, newColor, startingColor); //down
        helper(image, sr, sc-1, newColor, startingColor); //left
        helper(image, sr, sc+1, newColor, startingColor); //right
    }
}