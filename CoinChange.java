/*
Approach: We can either choose a particualr or not choose it. 
                   [1,2,5] 
                    /\
      1 not chosen /  \ 1 chosen
                  /    \
          11=[2,5]      [1,2,5]=10 
               \          \
        2 chosen\          \ 1 chosen
                 \          \                          
              9=[2,5]       [1,2,5]=9
                            /
                           / 1 not chosen
                          /
                   9=[2,5]
            
1. Greedy algorithm will not work here in every scenario 
2. We are running into recursive subtree problem
3. It would help to record the results of minimum number of coins required (from a particular subset of coins) to achieve a particular amount
as these results can be used later on
4. There are 2 constraints, the coins given and the amount to be achieved. We can use a matix, the columns would repesent the sum and the rows would
represent if the coin was picked or not.
5. Every value in the matrix would reperesent 2 cases. If the coin was picked, or it wasn't. We will calculate the minimum of both and store that in the matrix

Time complexity: O(logMN) : m=number of coins. n=amount to be achieved. 
Space complexiy: O(logMN) : m=number of coins. n=amount to be achieved.
*/
class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[][] matrix = new int[coins.length+1][amount+1];
        int i; int j;
        for(int z=1;z<=amount;z++)
            matrix[0][z]=10001; //set this to max value because this would be the 0th case for the 1st column
        for(i=1; i<matrix.length; i++) //Start from 2nd row. The first row would be all 0s, as we go back 1 step for the first  
        {
            for(j=1; j<matrix[0].length; j++)
            {
                if(coins[i-1]>j)
                    matrix[i][j]=matrix[i-1][j];
                else
                    matrix[i][j]=Math.min(matrix[i-1][j],matrix[i][j-coins[i-1]]+1);
            }
        }
        int result = matrix[coins.length][amount];
        if(result>amount)
            return -1;
        return result;
    }
}