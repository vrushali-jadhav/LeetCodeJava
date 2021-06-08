/*Approach:
1. Validtae the colmns by using a visited array and storing the element seen at index element-1
2. Validtae the rows by using a visited array and storing the element seen at index element-1
3. Validate the 3*3 boxes by using the visied array again

Time complexity: Each element is visisted thrice, so the complexity would be O(3N), but the 3 doesn't matter, so O(N)
Space complexity: O(1) as we only use one viisted matrix that can only store upto 9 elements
*/
class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] visited;
        int numRow;
        int numCol;

        //validate columns
        for(int i=0; i<=8; i++)
        {
            visited = new int[9];
            for(int j=0; j<=8; j++)
            {
                numRow = 0;
                if(board[i][j]!='.')
                    numRow = Character.getNumericValue(board[i][j]);

                //'.' char
                if(numRow==0)
                    continue;

                if(visited[numRow-1] == 1)
                    return false;
                else
                    visited[numRow-1] = 1;
            }
        }

        //validate rows
        for(int i=0; i<=8; i++)
        {
            visited = new int[9];
            for(int j=0; j<=8; j++)
            {
                numCol = 0;
                if(board[j][i]!='.')
                    numCol = Character.getNumericValue(board[j][i]);

                //'.' char
                if(numCol==0)
                    continue;

                if(visited[numCol-1] == 1)
                    return false;
                else
                    visited[numCol-1] = 1;
            }
        }

        int num;
        for(int block=0; block<=8; block++)
        {
            visited = new int[9];
            for(int i=block/3*3; i<block/3*3+3; i++)
            {
                for(int j=block%3*3; j<block%3*3+3; j++)
                {
                    num=0;
                    if(board[i][j]!='.')
                        num = Character.getNumericValue(board[i][j]);
                    //'.' char
                    if(num==0)
                        continue;
                    if(visited[num-1] == 1)
                        return false;
                    else
                        visited[num-1] = 1;
                }
            }
        }
        return true;
    }
}