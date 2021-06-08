
class Solution {
    public int maxValue(int[] value, int[] weight, int capacity, int nItems) {
        int[][] dp = new int[nItems+1][(capacity/10)+1];
        int zeroCase;
        int pickedCase;
        int runningSumOfWeights = 0;
        for(int i=1; i<= dp.length-1;i++)
        {
            runningSumOfWeights += weight[i-1]; //this would give the combined weight being considered at the moment
            for(int j=1; j<= dp[0].length-1; j++)
            {
                int currentMaxWeight = 10*(j);
                int currentWeight = weight[i-1];
                zeroCase = dp[i-1][j];
                if(currentMaxWeight < currentWeight) //If max weight is smaller than the available weight
                    pickedCase = 0;
                else if(currentMaxWeight==currentWeight)
                {
                    /* Just pick the value for the weight as it will always be the max. Since 10+10 cannot be used from set [10,20] for max weight limit 20. You can only pick 10 once.
                    So the max you can achieve using 10 is 60.
                    * */
                    pickedCase = value[i-1];
                }
                else //current maximum available weight is greater than current weight. While analyzing 30 out of [10,20,30] for current max weight 50
                {
                    //how many coins can you choose. [10]: capacity 10, 1.
                    if(runningSumOfWeights<currentMaxWeight)
                        /* If the total available weights combined are less than the max weight, for example: [10,20] for max weight 40, we can just take the value
                        calculated for [10,20] max weight 30. As max weight 40 cannot be achieved with just [10,20]
                        */
                        pickedCase = dp[i][j-1];
                    else {
                        /* [10,20,30]: max weight 50. If we choose 30, that would be value 120. Weight 30 will be reduced from initial weight 50.
                        So we have max weight 20 for set [10,20]. Results for which were stored in dp, 3 index back.
                        * */
                        pickedCase = value[i - 1];
                        pickedCase += dp[i][j-currentWeight/10];
                    }
                }
                dp[i][j] = Math.max(zeroCase, pickedCase);
            }
        }
        return dp[nItems][capacity/10];
    }
}