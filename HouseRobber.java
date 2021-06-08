class HouseRobber {
    public int rob(int[] nums) {
    /* Possible approach, picking an alternate elements and caluclating the max. 
    But that would fail for: [2,1,1,2]
    Recursive approach:
    Go through every possible combination, if a house is not picked, all the house expect the one not picked are available. 
    if a house is picked, it's next neighbhor cannot be picked. 
        int sum=0;
        int max=0;
        return recursiveFunction(0, nums, sum);
    }
    private int recursiveFunction(int i, int[] houses, int sum)
    {
        //do the logic
        int picked = 0;
        int notPicked = 0;
        if(i<=houses.length-1)
        {
            //either I pick the house
            picked = recursiveFunction(i+2,houses,sum+houses[i]);

            //or I don't pick the house
            notPicked = recursiveFunction(i+1,houses,sum);
            return Math.max(picked,notPicked);
        }
        else
            return sum;
    }*/
  /* Dynamic programming approach 
        int[][] matrix = new int[nums.length][2];
        matrix[0][0]=0;
        matrix[0][1]=nums[0];
        for(int i=1;i<=matrix.length-1;i++)
        {
            //skip
            matrix[i][0]=Math.max(matrix[i-1][0],matrix[i-1][1]);
            //take
            if(i-2>=0)
                matrix[i][1]=Math.max(matrix[i-2][0],matrix[i-2][1])+nums[i];
            else
                matrix[i][1]=nums[i];
        }
        return Math.max(matrix[matrix.length-1][0],matrix[matrix.length-1][1]);
  */
  /* Eeither we skip the number or we take it. If we skip the number, we need to take the max from the last house subtree. 
     If we take the number, than we have to go to the subtree of the house skipping the neighbhor and add the current houses amount. 
     The trick is that we only need information of the last step. Which can be stored in 2 variables (if you skipped or your picked). 
     This can be done using just 2 variables. Instead of using a matrix. 
     
     time complexity: O(N)
     space complexity: O(1)
  */   
    int skip = 0;
    int take = nums[0];
    int temp = 0;
    for(int i=1;i<=nums.length-1;i++)
    {
        temp = skip;
        skip = Math.max(temp,take);
        take = temp+nums[i];
    }
    return Math.max(skip,take);
  }
}